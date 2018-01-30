import scala.scalajs.js
import js.Dynamic.literal

object Dialog extends js.Object {

  def openConfirm(): Unit = {
    wx.showModal(literal(
      title = "弹窗标题",
      content = "弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内",
      confirmText = "主操作",
      cancelText = "辅助操作",
      success = (res: js.Dynamic) => {
        println(res)
        val msg = if(res.confirm.asInstanceOf[Boolean]) "用户点击主操作" else "用户点击辅助操作"
        println(msg)
      }
    ))
  }

  def openAlert(): Unit = {
    wx.showModal(literal(
      content = "",
      showCancel = false,
      success = (res: js.Dynamic) => {
        if (res.confirm.asInstanceOf[Boolean]) {
          println("用户点击确定")
        }
      }
    ))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Dialog)
  }
}
