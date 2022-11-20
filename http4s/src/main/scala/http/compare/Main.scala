package http.compare

import cats.effect._
import com.comcast.ip4s._
import http.compare.routes.HelloRoute
import org.http4s.ember.server._
import org.http4s.server.Router

class Main extends IOApp {

  val helloRoute = new HelloRoute()

  val httpApp = Router("/" -> helloRoute.helloWorldService).orNotFound

  override def run(args: List[String]): IO[ExitCode] = EmberServerBuilder
    .default[IO]
    .withHost(ipv4"0.0.0.0")
    .withPort(port"8080")
    .withHttpApp(httpApp)
    .build
    .use(_ => IO.never)
    .as(ExitCode.Success)
}
