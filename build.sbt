ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = Projects
  .createModule("scala-http-benchmark", ".")
  .aggregate(modules: _*)

lazy val akka = Projects
  .createModule("akka-http")
  .settings(Dependencies.akka)

lazy val tapir = Projects
  .createModule("tapir")
  .settings(Dependencies.tapir)

lazy val http4s = Projects
  .createModule("http4s")
  .settings(Dependencies.http4s)

lazy val zioHttp = Projects
  .createModule("zio-http")
  .settings(Dependencies.zioHttp)

lazy val modules: Seq[ProjectReference] = Seq(
  akka,
  tapir,
  http4s,
  zioHttp
)
