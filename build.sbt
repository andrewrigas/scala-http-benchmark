ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = Projects
  .createModule("scala-http-benchmark", ".")
  .aggregate(modules: _*)

lazy val akka = Projects.createModule("akka-http")

lazy val tapir = Projects
  .createModule("tapir")

lazy val http4s = Projects
  .createModule("http4s")

lazy val zio = Projects
  .createModule("zio-http")

lazy val modules: Seq[ProjectReference] = Seq(
  akka,
  tapir,
  http4s,
  zio
)