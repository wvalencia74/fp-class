name := "fp-class"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.typelevel" %% "cats-core" % "1.0.1")

scalacOptions ++= Seq(
  "-Ypartial-unification"
)