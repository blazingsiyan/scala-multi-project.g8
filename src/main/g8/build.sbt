lazy val buildSettings = Seq(
  organization := "$organization$",
  name := "$name$",
  version := "$version$",
  scalaVersion := "2.11.8",
  javacOptions ++= Seq("-source", "$jdkSourceVersion$", "-target", "$jdkTargetVersion$"),
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:implicitConversions",
    "-language:existentials",
    "-language:higherKinds",
    "-language:postfixOps",
    "-unchecked",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Xfuture",
    "-target:jvm-$jdkTargetVersion$"
  )
)

lazy val commonSettings = buildSettings ++ assemblySettings ++ Seq(
  libraryDependencies ++= Seq(
    "com.typesafe.scala-logging" %% "scala-logging"  % "3.5.0",
    "org.scalatest"              %% "scalatest"      % "3.0.0" % "test"
  )
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq())

lazy val assemblySettings = Seq(
  assemblyOutputPath in assembly := new File(s"target/\${artifact.value.name}.jar"),
  assemblyMergeStrategy in assembly := {
    case x if x.startsWith("META-INF") => MergeStrategy.discard
    case x if x.endsWith(".html")      => MergeStrategy.discard
    case x if x == "reference.conf"    => MergeStrategy.concat
    case PathList(ps @ _ *) if Assembly.isSystemJunkFile(ps.last) =>
      MergeStrategy.discard
    case _ => MergeStrategy.first
  }
)
