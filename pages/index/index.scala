import scala.scalajs.js
import js.Dynamic.literal

object Index extends js.Object {
  val data = literal(motto="hello world", userInfo=literal())

  def bindViewTap(): Unit = {
    val cb = () => {println("motto changed")}
    Wechat.setData(literal(motto="hello scala"),cb)
  }

  def onLoad(): Unit = {
    println("page index loaded...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Index)
  }
}
