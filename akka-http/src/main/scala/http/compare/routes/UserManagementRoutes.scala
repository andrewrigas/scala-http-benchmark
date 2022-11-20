package http.compare.routes

import akka.http.scaladsl.server.Directives._
import http.compare.repository.UserManagementRepository

class UserManagementRoutes(repository: UserManagementRepository) {

  val routes = ???

  private lazy val login = (path("login" / Segment / Segment ) & post) { (username, password) =>
    repository.getUserCredentials(username)
  }

  private lazy val register =

    private lazy val updateDetails =

}
