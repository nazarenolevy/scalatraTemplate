package com.example.app.common.logging

import java.io.{PrintWriter, StringWriter}

import org.slf4j.LoggerFactory

trait Logging {

  private lazy val LOGGER = LoggerFactory.getLogger(this.getClass)

  protected def trace(message: => String): Unit = LOGGER.trace(message)

  protected def debug(message: => String): Unit = LOGGER.debug(message)

  protected def info(message: => String): Unit = LOGGER.info(message)

  protected def warn(message: => String): Unit = LOGGER.warn(message)

  protected def error(message: => String): Unit = LOGGER.error(message)

  protected def error(message: => String, exception: Throwable): Unit =
    LOGGER.error(message, exception)

  protected def getStackTrace(throwable: Throwable): String = {
    val writer = new StringWriter
    val printWriter = new PrintWriter(writer)
    throwable.printStackTrace(printWriter)
    writer.toString
  }
}
