import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {

  object Versions {
    val akka         = "2.7.0"
    val akkaHttp     = "10.4.0"
    val akkaHttpJson = "1.39.2"

    val tapir = "1.2.2"

    val http4s = "0.23.16"

    val zioHttp = "0.0.3"
    val zioJSON = "0.3.0"

    val scalaTest          = "3.2.14"
    val scalaTestPlusCheck = "3.2.11.0"
    val scalacheck         = "1.17.0"
  }

  object Testing {
    val scalaTest          = "org.scalatest"     %% "scalatest"       % Versions.scalaTest          % Test
    val scalaTestPlusCheck = "org.scalatestplus" %% "scalacheck-1-15" % Versions.scalaTestPlusCheck % Test
    val scalacheck         = "org.scalacheck"    %% "scalacheck"      % Versions.scalacheck         % Test

    val all = Seq(scalaTest, scalaTestPlusCheck, scalacheck)
  }

  object Http4s {
    val dsl    = "org.http4s" %% "http4s-dsl"    % Versions.http4s
    val server = "org.http4s" %% "http4s-ember-server" % Versions.http4s
    val client = "org.http4s" %% "http4s-ember-client" % Versions.http4s

    val all = Seq(dsl, client, server)
  }

  object Tapir {
    val core = "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir

    val all = Seq(core)
  }

  object ZIO {
    val zioHttp = "dev.zio" %% "zio-http" % Versions.zioHttp

    val all = Seq(zioHttp)
  }

  object Akka {
    val akkaActorTyped = "com.typesafe.akka" %% "akka-actor-typed" % Versions.akka
    val akkaStream     = "com.typesafe.akka" %% "akka-stream"      % Versions.akka
    val akkaHttp       = "com.typesafe.akka" %% "akka-http"        % Versions.akkaHttp
    val akkaHttpJson   = "de.heikoseeberger" %% "akka-http-circe"  % Versions.akkaHttpJson

    val all = Seq(akkaActorTyped, akkaStream, akkaHttp, akkaHttpJson)
  }

  lazy val akka = libraryDependencies ++= Akka.all ++ Testing.all

  lazy val tapir = libraryDependencies ++= Tapir.all ++ Testing.all

  lazy val http4s = libraryDependencies ++= Http4s.all ++ Testing.all

  lazy val zioHttp = libraryDependencies ++= ZIO.all ++ Testing.all
}
