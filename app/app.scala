import scala.scalajs.js
import js.Dynamic.literal

object app extends js.Object {
  def onLaunch(options: js.Dynamic): Unit = {
      println("app launched...")
      val logs = wx.getStorageSync("logs").getOrElse(new js.Array[js.Date]())
      wx.setStorageSync("logs", js.Date.now() +: logs.asInstanceOf[js.Array[js.Date]])
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
