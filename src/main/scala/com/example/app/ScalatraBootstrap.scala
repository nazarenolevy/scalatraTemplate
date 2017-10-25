import javax.servlet.ServletContext

import com.example.app.common.filter.{LoggingFilter, RoutingFilter}
import com.example.app.common.logging.Logging
import com.example.app.controller.MyScalatraController
import com.example.app.external.MariaDB
import com.example.app.modules.{ExternalModule, FiltersModule, GlobalModule}
import org.scalatra._
import scaldi.{Injectable, Injector}


class ScalatraBootstrap extends LifeCycle with Injectable with Logging {

  implicit val inj: Injector = new GlobalModule ++ new ExternalModule ++ new FiltersModule

  override def init(context: ServletContext) {

    inject[MariaDB].init()

    //Filters
    context.mount(inject[RoutingFilter], "/*")
    context.mount(inject[LoggingFilter], "/*")


    //Controllers
    context.mount(inject[MyScalatraController], "/test")

  }

  override def destroy(context: ServletContext) = super.destroy(context)
}
