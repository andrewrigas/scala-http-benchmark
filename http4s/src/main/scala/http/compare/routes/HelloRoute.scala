package http.compare.routes

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._

class HelloRoute {

  val helloWorldService = HttpRoutes.of[IO] { case GET -> Root / "hello" / name =>
    Ok(s"Hello, $name.")
  }

}
