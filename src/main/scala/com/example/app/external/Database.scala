package com.example.app.external

import com.example.app.common.logging.Logging
import com.example.app.common.util.ConfigReader
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.squeryl.adapters.MySQLInnoDBAdapter
import org.squeryl.{Session, SessionFactory}


trait Database extends Logging with ConfigReader {

  val databaseUsername = ""
  val databasePassword = ""
  val driverClass = ""
  val jdbcUrl = ""

  def init() = {

    val dataSource = new ComboPooledDataSource
    dataSource.setDriverClass(driverClass)
    dataSource.setUser(databaseUsername)
    dataSource.setPassword(databasePassword)
    dataSource.setUnreturnedConnectionTimeout(600)
    dataSource.setMinPoolSize(32)
    dataSource.setMaxPoolSize(64)
    dataSource.setCheckoutTimeout(60000)
    dataSource.setMaxIdleTimeExcessConnections(240)
    dataSource.setIdleConnectionTestPeriod(300)
    dataSource.setTestConnectionOnCheckin(true)
    dataSource.setPreferredTestQuery("SELECT 1")
    dataSource.setJdbcUrl(jdbcUrl)


    SessionFactory.concreteFactory = Some(() => connection)

    def connection = {
      info("Creating connection with c3po connection pool")
      Session.create(dataSource.getConnection, new MySQLInnoDBAdapter)
    }
  }

  def connect()

  def get()

  def save()

}
