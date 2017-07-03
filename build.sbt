name := "scala_book"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
  "junit" % "junit" % "4.12",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
  "com.typesafe.akka" %% "akka-actor" % "2.5.2"
)
        