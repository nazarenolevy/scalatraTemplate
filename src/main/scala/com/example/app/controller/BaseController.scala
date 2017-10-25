package com.example.app.controller
import org.json4s.{DefaultFormats, Formats, JValue}
import org.scalatra.json._
import com.example.app.common.logging.Logging
import org.scalatra.ScalatraServlet

class BaseController extends ScalatraServlet with Logging with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  protected override def transformRequestBody(body: JValue): JValue = body.underscoreKeys

  protected override def transformResponseBody(body: JValue): JValue = body.underscoreKeys

  before(){
    format_=("json")
  }

}
