package com.example.app.modules

import com.example.app.external.{MariaDB, MongoDB}
import scaldi.Module

class ExternalModule extends Module {

  binding toNonLazy new MariaDB
  binding toNonLazy new MongoDB

}
