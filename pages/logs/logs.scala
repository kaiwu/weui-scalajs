import scala.scalajs.js

object Logs extends js.Object {
  def onLoad = {
    println("page logs loaded...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    wechatapp.Page(Logs)
  }
}
