import scala.scalajs.js
import js.Dynamic.literal

object Msg extends js.Object {
  def openSuccess(): Unit = {
    wx.navigateTo(literal(url = "../msg_success/msg_success"))
  }
  def openFail(): Unit = {
    wx.navigateTo(literal(url = "../msg_fail/msg_fail"))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Msg)
  }
}
