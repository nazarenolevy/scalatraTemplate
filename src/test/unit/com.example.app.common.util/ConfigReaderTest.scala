package com.example.app.common.util

import com.example.app.UnitTest
import com.example.app.common.logging.Logging
import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite

class ConfigReaderTest extends UnitTest with ScalatraSuite with FunSuiteLike with Logging {

  test("Should read the configuration"){
    val config = ConfigFactory.load()

    info(s"${config.entrySet()}")

  }



}
