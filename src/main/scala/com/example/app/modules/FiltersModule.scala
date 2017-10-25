package com.example.app.modules

import com.example.app.common.filter.{LoggingFilter, RoutingFilter}
import scaldi.Module

class FiltersModule extends Module {

  bind [LoggingFilter] to new LoggingFilter
  bind [RoutingFilter] to new RoutingFilter

}
