import scala.scalajs.js
import js.Dynamic.literal

object Searchbar extends js.Object {
  val data = literal(inputShowed = false,inputVal="")

  def showInput(): Unit = {
    Wechat.setData(literal(inputShowed=true))
  }
  def hideInput(): Unit = {
    Wechat.setData(literal(inputShowed=false,inputVal=""))
  }
  def clearInput(): Unit = {
    Wechat.setData(literal(inputVal=""))
  }
  def inputTyping(e: WxEvent): Unit = {
    Wechat.setData(literal(inputVal=e.detail.value.asInstanceOf[String]))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Searchbar)
  }
}
