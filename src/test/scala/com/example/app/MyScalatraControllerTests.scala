package com.example.app

import com.example.app.controller.MyScalatraController
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class MyScalatraControllerTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[MyScalatraController], "/*")

  test("GET / on MyScalatraServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
