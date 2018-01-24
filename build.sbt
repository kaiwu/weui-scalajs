name := "WeUI Demo"

import  com.typesafe.sbt.web._
import  Import.WebKeys._

lazy val root = (project in file("."))
                .aggregate(common, app, index, logs)

lazy val common = (project in file("common"))
                  .enablePlugins(ScalaJSPlugin)
                 
lazy val commonSettings = Seq(
     sourceDirectory in Assets := baseDirectory.value,
     public in Assets := webTarget.value,
     includeFilter in Assets := "*.wxml" | "*.wxss" | "*.json",
     emitSourceMaps in fullOptJS in Compile := false,
     scalacOptions += "-P:scalajs:sjsDefinedByDefault",
     scalaJSUseMainModuleInitializer := true
)

lazy val app = (project in file("app"))
               .enablePlugins(SbtWeb,ScalaJSPlugin)
               .dependsOn(common)
               .settings(
                 commonSettings,
                 webTarget := target.value / ".." / ".." / "target",
                 artifactPath in fullOptJS in Compile := webTarget.value / "app.js"
               )

lazy val index = (project in file("pages/index"))
                 .enablePlugins(SbtWeb,ScalaJSPlugin)
                 .dependsOn(common)
                 .settings(
                   commonSettings,
                   webTarget := target.value / ".." / ".." / ".." / "target" / "pages" / "index",
                   artifactPath in fullOptJS in Compile := webTarget.value / "index.js"
                 )

lazy val logs = (project in file("pages/logs"))
                .enablePlugins(SbtWeb,ScalaJSPlugin)
                .dependsOn(common)
                .settings(
                   commonSettings,
                   webTarget := target.value / ".." / ".." / ".." / "target" / "pages" / "logs",
                   artifactPath in fullOptJS in Compile := webTarget.value / "logs.js"
                )


