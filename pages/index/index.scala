import scala.scalajs.js

object Index extends js.Object {
  def onLoad = {
    println("page index loaded...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    wechatapp.Page(Index)
  }
}
