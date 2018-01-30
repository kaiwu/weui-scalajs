import scala.scalajs.js
import js.Dynamic.literal

object Actionsheet extends js.Object {
  def open(): Unit = {
    val done = (res: js.Dynamic) => {
      if (!(res.cancel).asInstanceOf[Boolean]) {
        println(res.tapIndex)
      }
    }

    wx.showActionSheet(literal(
      itemList = js.Array[String]("A","B","C"),
      success = done
    ))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Actionsheet)
  }
}
