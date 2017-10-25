package com.example.app.common.filter

import javax.servlet.{FilterChain, ServletRequest, ServletResponse}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import com.example.app.common.logging.Logging
import org.scalatra.ScalatraFilter
import org.slf4j.MDC


class LoggingFilter extends ScalatraFilter with RitchFilter {

  override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain): Unit = {
    val httpRequest = request.asInstanceOf[HttpServletRequest]
    val httpResponse = response.asInstanceOf[HttpServletResponse]

    val startTime = System.currentTimeMillis
    info(s"START - ${httpRequest.requestMethod} ${httpRequest.uri}")

    chain.doFilter(request, response)

    val requestTime = System.currentTimeMillis - startTime
    info(s"END - ${httpRequest.requestMethod} ${httpRequest.uri} took $requestTime ms and returned ${httpResponse.getStatus}")

  }
}