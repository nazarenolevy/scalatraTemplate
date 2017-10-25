package com.example.app.common.util

import java.nio.file.{Files, Paths}

import com.example.app.common.logging.Logging
import com.typesafe.config.{Config, ConfigFactory}
import org.joda.time.DateTime

import scala.util.Try

trait ConfigReader {
  protected def envConfiguration = ConfigReader.eConfiguration
}


object ConfigReader extends Logging {
  import scala.collection.immutable._
  import scala.collection.JavaConversions._

  private val EnvironmentKey = "environment"
  private val OverrideKey = "override"
  private val OverrideJvmOpt = "overrideFileDir"
  private val OverrideFileName = "application-override.conf"

  @volatile protected[common] var eConfiguration = initConfiguration()

  private lazy val defaultConfig: Config = ConfigFactory.load()

  private lazy val environment: String = defaultConfig.getString(EnvironmentKey)
  private def initConfiguration(): Config = reloadConfiguration()

  private[this] var lastReload: DateTime = DateTime.now()

  def reloadConfig(overridingConfigMap: Map[String, _ <: Any] = Map()): Try[DateTime] = synchronized {
    Try {
      info("Reloading the configuration...")
      val olderReload = lastReload

      ConfigFactory.invalidateCaches()
      ConfigReader.eConfiguration = ConfigReader.reloadConfiguration(overridingConfigMap)

      lastReload = DateTime.now()
      olderReload
    }
  }

  private[common] def reloadConfiguration(overridingConfigMap: Map[String, _ <: Any] = Map()): Config = {
    val overrideConf: Config = ConfigFactory.parseMap(overridingConfigMap)
    val eConf = overrideConf.withFallback(ConfigFactory.load().getConfig(environment).withFallback(defaultConfig))
    Option(System.getProperty(OverrideJvmOpt)).map(loadOverrideConfFile(_, eConf)).getOrElse(eConf)
  }

  private def loadOverrideConfFile(overridePath: String, eConf: Config): Config = {
    val path = Paths.get(overridePath, OverrideFileName)
    if (Files.notExists(path)) {
      eConf
    } else {
      ConfigFactory.parseFile(path.toFile).getConfig(OverrideKey).withFallback(eConf)
    }
  }

}
