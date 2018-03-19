import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.ExecutionContext.Implicits.global

//implicit
import Wechat.errorCallback

object Main {
  val component = literal (
    data = literal(motto="hello world", userInfo=literal()),

    showDialog = () => {
      val c = Wechat.selectComponent("#dialog")
      c.setData(literal(isShow = true))
    },

    _cancelEvent = () => {
      println("你点击了取消");
      val c = Wechat.selectComponent("#dialog")
      c.setData(literal(isShow = false))
    },

    _confirmEvent = () => {
      println("你点击了确定");
      val c = Wechat.selectComponent("#dialog")
      c.setData(literal(isShow = false))
    },

    onReady = () => {
      val c = Wechat.selectComponent("#dialog")
      c.asInstanceOf[js.Dynamic]._cancelEvent  = (e: js.Dynamic) => c.triggerEvent("cancelEvent",literal(),literal())
      c.asInstanceOf[js.Dynamic]._confirmEvent = (e: js.Dynamic) => c.triggerEvent("confirmEvent",literal(),literal())
    },

    onLoad = () => {
      val info = for {
        msg  <- Wechat.login{}
        info <- Wechat.getUserInfo(false,"en"){}
      } yield info

      Wechat.setData("userInfo", info)
    }
  )
  def main(args: Array[String]): Unit = {
    Page(js.Object.create(component))
  }
}
