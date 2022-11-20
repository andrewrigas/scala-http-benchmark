package http.compare

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http

class Main extends App {

  implicit val system = ActorSystem(Behaviors.empty, "my-system")
  implicit val executionContext = system.executionContext

  val helloRoute = new HelloRoute()


  val routes = helloRoute.route

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(routes)

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
