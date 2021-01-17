organization := "com.knoldus"
name := "Assignment_sbt"
version := "1.4.4"
scalaVersion := "2.12.12"


lazy val common = project.in(file("common")).settings(libraryDependencies ++=Seq(
  "org.json4s" %% "json4s-native" % "3.5.4",
  "com.typesafe" % "config" % "1.4.1",
  "org.scalatest" %% "scalatest" % "3.0.0" % Test,
  "org.slf4j" % "slf4j-api" % "2.0.0-alpha1",
  "org.mockito" %% "mockito-scala" % "1.16.15"
))

lazy val persistence = project.in(file("persistence")).settings(libraryDependencies ++=Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.postgresql" % "postgresql" % "42.2.18",
  "com.h2database" % "h2" % "1.4.200" % Test
))dependsOn(common)

lazy val root = project.in(file(".")).aggregate(common, persistence)
