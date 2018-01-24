import scala.scalajs.js

object App extends js.Object {
  def onLaunch = {
      println("app launched...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    wechatapp.App(App)
  }
}
