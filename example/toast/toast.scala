import scala.scalajs.js
import js.Dynamic.literal

object Toast extends js.Object {
  def openToast(): Unit = {
    wx.showToast(literal(
      title = "已完成",
      icon = "success",
      duration = 3000
    ))
  }

  def openLoading(): Unit = {
    wx.showToast(literal(
      title = "数据加载中",
      icon = "loading",
      duration = 3000
    ))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Toast)
  }
}
