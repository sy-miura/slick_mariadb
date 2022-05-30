name := """slick_mysql"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

resolvers += "Atlassian Releases" at "https://maven.atlassian.com/public/"
resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"
//resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"




libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

//libraryDependencies += "com.zaxxer" % "HikariCP" % "2.7.4"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.0.0"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.3.3"
//libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
