package com.example.app

import com.example.app.common.util.ConfigReader

abstract class UnitTest {

  System.setProperty("config.file", "./src/test/resources/application.conf")
  ConfigReader.reloadConfig()


}
