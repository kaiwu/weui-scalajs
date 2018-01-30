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
object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
