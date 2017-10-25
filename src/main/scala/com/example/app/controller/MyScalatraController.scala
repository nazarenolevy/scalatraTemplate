package com.example.app.controller

class MyScalatraController extends BaseController {

  get("/a/1") {
    Test("campo unooo", 2)
  }

  get("/2") {
    "2"
  }
}

case class Test(campoUno: String, campoDos: Int)
