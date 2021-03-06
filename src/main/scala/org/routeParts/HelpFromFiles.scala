package org.routeParts

import akka.http.scaladsl.model.StatusCodes.PermanentRedirect
import org.webService.WebServicePart
import org.helpers.AppSettings._

object HelpFromFiles extends WebServicePart {

  override def RouteGenerator = {
    val result = get {
      path("fonts" / Segment) { name ⇒
        getFromResource(s"helpHttp/fonts/$name")
      } ~ path("helpHttp" / Segment) { name ⇒
        getFromResource(s"helpHttp/$name")
      } ~ pathSingleSlash {
        //getFromResource("helpHttp/index.html")
        redirect("helpHttp/index.html", PermanentRedirect)
      }
    }
    appLogger.debug("Created route - routeFiles")
    result
  }
}
