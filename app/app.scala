import scala.scalajs.js
import js.Dynamic.literal

object app extends js.Object {
  val globalData = literal(hasLogin = false)

  def onLaunch(): Unit = {
    println("App Launch")
  }
  def onShow(): Unit = {
    println("App Show")
  }
  def onHide(): Unit = {
    println("App Hide")
  }
}

//"pages": [
//  "example/index/index",
//
//  "example/button/button",
//  "example/list/list",
//  "example/input/input",
//  "example/slider/slider",
//  "example/uploader/uploader",
//
//  "example/article/article",
//  "example/badge/badge",
//  "example/flex/flex",
//  "example/footer/footer",
//  "example/gallery/gallery",
//  "example/grid/grid",
//  "example/icons/icons",
//  "example/loadmore/loadmore",
//  "example/panel/panel",
//  "example/preview/preview",
//  "example/progress/progress",
//
//  "example/actionsheet/actionsheet",
//  "example/dialog/dialog",
//  "example/msg/msg",
//  "example/msg/msg_success",
//  "example/msg/msg_fail",
//  "example/picker/picker",
//  "example/toast/toast",
//
//  "example/navbar/navbar",
//  "example/tabbar/tabbar",
//
//  "example/searchbar/searchbar"
//],

object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
