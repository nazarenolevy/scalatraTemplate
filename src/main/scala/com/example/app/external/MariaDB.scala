package com.example.app.external

class MariaDB extends Database {

  val config = envConfiguration.getConfig("mariaDB")

  override val databaseUsername: String = config.getString("databaseUsername")
  override val databasePassword: String = config.getString("databasePassword")
  override val driverClass: String = config.getString("driverClass")
  override val jdbcUrl: String = s"jdbc:mariadb://${config.getString("driverClass")}/"

  override def connect(): Unit = {}

  override def get(): Unit = {}

  override def save(): Unit = {}
}
