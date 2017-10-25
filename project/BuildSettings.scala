import sbt.Keys._
import sbt._

object BuildSettings {

  lazy val basicSettings = Seq(
    name                  := "example",
    startYear             := Some(2017),
    organization          := "com.example",
    scalaVersion          := "2.12.3",
    scalacOptions         += "-feature",
    scalacOptions         += "-language:implicitConversions",
    scalacOptions         += "-language:reflectiveCalls",
    scalacOptions         += "-language:postfixOps",
    crossPaths            := false,
    doc in Compile        := target.value,
    testOptions in Test   := Nil,
    resolvers             += Classpaths.typesafeReleases,
    version               := "0.1.0-SNAPSHOT"
  )

}