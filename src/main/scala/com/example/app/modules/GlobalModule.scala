package com.example.app.modules

import com.example.app.controller.MyScalatraController
import scaldi.Module

class GlobalModule extends Module {

  bind [MyScalatraController] to new MyScalatraController

}