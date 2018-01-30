import scala.scalajs.js
import js.Dynamic.literal

object Picker extends js.Object {
  val data = literal(
    array = js.Array[String]("美国", "中国", "巴西", "日本"),
    index = 0,
    date = "2016-09-01",
    time = "12:01"
  )

  def bindPickerChange(e: WxEvent): Unit = {
    println("picker发送选择改变，携带值为 ", e.detail.value.asInstanceOf[String])
    Wechat.setData(literal(index = e.detail.value))
  }

  def bindDateChange(e: WxEvent): Unit = {
    Wechat.setData(literal(date = e.detail.value))
  }

  def bindTimeChange(e: WxEvent): Unit = {
    Wechat.setData(literal(time = e.detail.value))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Picker)
  }
}
