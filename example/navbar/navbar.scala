import scala.scalajs.js
import js.Dynamic.literal

object Navbar extends js.Object {
  val data = literal(
    tabs = js.Array[String]("选项一", "选项二", "选项三"),
    activeIndex = 1,
    sliderOffset = 0,
    sliderLeft = 0,
    sliderWidth = 96 // 需要设置slider的宽度，用于计算中间位置
  )

  def onLoad(): Unit = {
    val done = (res: js.Dynamic) => {
      val width = res.windowWidth
      Wechat.setData(literal(
        sliderLeft = ( width / this.data.tabs.length - this.data.sliderWidth).asInstanceOf[Int] / 2,
        sliderOffset = width / this.data.tabs.length * this.data.activeIndex
      ))
    }
    wx.getSystemInfo(literal(
      success = done
    ))
  }

  def tabClick(e: WxEvent): Unit = {
    Wechat.setData(literal(
      sliderOffset = e.currentTarget.offsetLeft,
      activeIndex = e.currentTarget.id
    ))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Navbar)
  }
}
