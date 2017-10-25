package com.example.app.common.filter

import javax.servlet.ServletRequest
import javax.servlet.http.HttpServletRequest
import com.example.app.common.logging.Logging
import org.scalatra.servlet.RichRequest

trait RitchFilter extends Logging {

  implicit class toRichRequest(request: ServletRequest) {
    def toRichRequest: RichRequest = RichRequest(request.asInstanceOf[HttpServletRequest])
  }

  implicit class Extractor(request: RichRequest) {

    def extractCookieOrHeader(name: String): Option[String] = {
      (request.cookies.get(name), request.header(name)) match {
        case (Some(value), _) => Option(value)
        case (None, Some(value)) => Option(value)
        case (_, _) => None
      }
    }
  }
}
