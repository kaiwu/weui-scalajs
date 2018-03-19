import scala.scalajs.js
import js.Dynamic.literal
import js.Dynamic.{global => g}

object Main {
  val dialog = literal (
    options = literal(multipleSlots = true),
    properties = literal (
      title = literal(`type` = g.String, value = "标题"),
      content = literal(`type` = g.String, value = "弹窗内容"),
      cancelText = literal(`type` = g.String, value = "取消"),
      confirmText = literal(`type` = g.String, value = "确定")
    ),
    data = literal(isShow = false),
    methods = literal (
    )
  )
  def main(args: Array[String]): Unit = {
    Component(js.Object.create(dialog))
  }
}
