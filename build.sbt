name := "WeUI Demo"

import  com.typesafe.sbt.web._
import  Import.WebKeys._

lazy val root = (project in file("."))
                .aggregate(common, app, index, actionsheet,
                           article, badge, button, dialog, flex,
                           footer,  gallery, grid, icons, images,
                           input, list, loadmore, msg, navbar,
                           panel, picker, preview, progress,
                           searchbar, slider, tabbar, toast, uploader)

lazy val common = (project in file("common"))
                  .enablePlugins(ScalaJSPlugin)
                 
lazy val commonSettings = Seq(
     sourceDirectory in Assets := baseDirectory.value,
     public in Assets := webTarget.value,
     includeFilter in Assets := "*.wxml" | "*.json",
     includeFilter in (Assets, LessKeys.less) := "*.wxss",
     excludeFilter in (Assets, LessKeys.less) := "_*.wxss",
     managedSources in (Assets, LessKeys.less) := (sourceDirectory in Assets).value.descendantsExcept((includeFilter in (Assets, LessKeys.less)).value, excludeFilter.value).get,
     LessKeys.sourceMap in Assets := false,
     emitSourceMaps in fullOptJS in Compile := false,
     scalacOptions += "-P:scalajs:sjsDefinedByDefault",
     scalaJSUseMainModuleInitializer := true,
     webTarget := target.value / ".." / ".." / ".." / "target" / "example" / name.value,
     artifactPath in fullOptJS in Compile := webTarget.value / (name.value + ".js")
)

lazy val app   = (project in file("app"))
                 .enablePlugins(SbtWeb,ScalaJSPlugin)
                 .dependsOn(common)
                 .settings(
                   commonSettings,
                   webTarget := target.value / ".." / ".." / "target"
                 )

lazy val index = (project in file("example/index")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val actionsheet = (project in file("example/actionsheet")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val article = (project in file("example/article")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val badge = (project in file("example/badge")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val button = (project in file("example/button")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val dialog = (project in file("example/dialog")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val flex = (project in file("example/flex")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val footer = (project in file("example/footer")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val gallery = (project in file("example/gallery")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val grid = (project in file("example/grid")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val icons = (project in file("example/icons")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val images = (project in file("example/images")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val input = (project in file("example/input")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val list = (project in file("example/list")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val loadmore = (project in file("example/loadmore")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val msg = (project in file("example/msg")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val navbar = (project in file("example/navbar")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val panel = (project in file("example/panel")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val picker = (project in file("example/picker")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val preview = (project in file("example/preview")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val progress = (project in file("example/progress")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val searchbar = (project in file("example/searchbar")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val slider = (project in file("example/slider")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val tabbar = (project in file("example/tabbar")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val toast = (project in file("example/toast")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
lazy val uploader = (project in file("example/uploader")).enablePlugins(SbtWeb,ScalaJSPlugin).dependsOn(common).settings(commonSettings)
