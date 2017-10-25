package com.example.app.common.util

import com.example.app.UnitTest
import com.example.app.common.logging.Logging
import org.scalatest.FunSuiteLike
import net.ceedubs.ficus.Ficus._
import org.scalatra.test.scalatest.ScalatraSuite

class ConfigReaderTest extends UnitTest with ScalatraSuite with FunSuiteLike with ConfigReader {

  test("Should read the configuration"){
    envConfiguration.as[String]("environment") shouldBe "test"
  }

  test("Should override the configuration"){
    ConfigReader.reloadConfig(Map("environment" -> "bla"))
    envConfiguration.as[String]("environment") shouldBe "bla"
  }

}
