package com.example.app

import com.example.app.controller.BaseController

class MyScalatraController extends BaseController {

  get("/a/1") {
    "1"
  }

  get("/2") {
    "2"
  }
}
