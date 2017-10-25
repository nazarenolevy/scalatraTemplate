import sbt._
import sbt.Keys._
import BuildSettings._
import TestSettings._

val ScalatraVersion = "2.5.1"

lazy val root = (project in file(".")).
  enablePlugins(SbtTwirl).
  enablePlugins(ScalatraPlugin).
  settings(basicSettings).
  configs(testConfigs: _*).
  settings(allTestSettings: _*).
  settings(
    /*
    // BuildInfo
    buildInfoKeys := Seq[BuildInfoKey](organization, name, version), //, scalaVersion, sbtVersion),
    buildInfoPackage := "com.example",
*/
    // Dependencies
    libraryDependencies ++=Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.scaldi" %% "scaldi" % "0.5.8",
      "com.mchange" % "c3p0" % "0.9.5.2",
      "org.squeryl" %% "squeryl" % "0.9.7",
      "org.mariadb.jdbc" % "mariadb-java-client" % "2.0.3",
      "joda-time" % "joda-time" % "2.9.9",
      "com.typesafe" % "config" % "1.3.1"
    ),
  )