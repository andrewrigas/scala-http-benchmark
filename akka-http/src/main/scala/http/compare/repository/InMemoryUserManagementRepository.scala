package http.compare.repository
import http.compare.model.{Credentials, UserInfo}

import java.util.Date
import scala.collection.concurrent._
import scala.concurrent.Future
import scala.util.chaining.scalaUtilChainingOps

class InMemoryUserManagementRepository() extends UserManagementRepository {

  private lazy val database = TrieMap.empty[String, UserInfo]

  override def createUser(username: String, password: String, dob: Date, address: String): Future[Unit] =
    (database += username -> UserInfo(password, dob, address))
      .pipe(_ => Future.unit)

  override def getUserCredentials(username: String): Future[Option[Credentials]] =
    database
      .get(username)
      .map(userInfo => Credentials(username, userInfo.password))
      .pipe(Future.successful)

  override def updateUserInfo(username: String,
                              maybePassword: Option[String],
                              maybeDOB: Option[Date],
                              maybeAddress: Option[String]
  ): Future[Unit] =
    database
      .get(username)
      .map(
        _.pipe(userInfo => maybeDOB.map(dob => userInfo.copy(dob = dob)).getOrElse(userInfo))
          .pipe(userInfo => maybePassword.map(password => userInfo.copy(password = password)).getOrElse(userInfo))
          .pipe(userInfo => maybeAddress.map(address => userInfo.copy(address = address)).getOrElse(userInfo))
      )
      .map(userInfo => database.replace(username, userInfo))
      .pipe(_ => Future.unit)
}
