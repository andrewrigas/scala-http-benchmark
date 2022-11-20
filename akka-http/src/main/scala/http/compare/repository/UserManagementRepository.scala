package http.compare.repository

import http.compare.model.Credentials

import java.util.Date
import scala.concurrent.Future

trait UserManagementRepository {

  def createUser(username: String, password: String, dob: Date, address: String): Future[Unit]

  def getUserCredentials(username: String): Future[Option[Credentials]]

  def updateUserInfo(username: String, maybeDOB: Option[Date], maybeAddress: Option[String]): Future[Unit]
}
