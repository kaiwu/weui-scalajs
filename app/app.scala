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

object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
