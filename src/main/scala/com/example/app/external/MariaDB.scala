package com.example.app.external

class MariaDB extends Database {

  override val databaseUsername: String = "root"
  override val databasePassword: String = ""
  override val driverClass: String = "org.mariadb.jdbc.Driver"

  override def connect(): Unit = {}

  override def get(): Unit = {}

  override def save(): Unit = {}
}
