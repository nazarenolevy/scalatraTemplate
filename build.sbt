import sbt._
import sbt.Keys._

val ScalatraVersion = "2.5.1"

organization := "com.example"

name := "example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.3"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scaldi" %% "scaldi" % "0.5.8",
  "com.mchange" % "c3p0" % "0.9.5.2",
  "org.squeryl" %% "squeryl" % "0.9.7",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.0.3",
  "joda-time" % "joda-time" % "2.9.9"
)

javaOptions ++= Seq(
  "-Xdebug",
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005")

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)


