package com.example.app.common.filter

import javax.servlet.{FilterChain, ServletRequest, ServletResponse}
import org.joda.time.DateTime
import org.scalatra.ScalatraFilter
import org.scalatra.servlet.RichRequest
import org.slf4j.MDC

import scala.util.Random

class RoutingFilter extends ScalatraFilter with RitchFilter {

  override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain): Unit = {
    val richRequest = request.toRichRequest

    val uow = richRequest.extractCookieOrHeader(UOW).getOrElse(createUOW(richRequest))
    val requestId = richRequest.extractCookieOrHeader(REQUEST_ID).getOrElse(Random.alphanumeric.take(10).mkString)
    val uid = richRequest.extractCookieOrHeader(USER_ID).getOrElse(UNKNOWN)

    MDC.put(UOW, uow)
    MDC.put(USER_ID, uid)
    MDC.put(REQUEST_ID, requestId)

    chain.doFilter(request, response)
  }


  private def createUOW(request: RichRequest): String = {

    val host = request.header(HOST).getOrElse(UNKNOWN)
    val millis = DateTime.now().getMillis
    List(host, millis).mkString("-")
  }

}
