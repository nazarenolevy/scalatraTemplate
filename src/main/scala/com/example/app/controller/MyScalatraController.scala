package com.example.app.controller

class MyScalatraController extends BaseController {

  get("/a/1") {
    "1"
  }

  get("/2") {
    "2"
  }
}
