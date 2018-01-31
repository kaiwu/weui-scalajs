import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.{Future,Promise}

object Wechat {
  val callback = () => {}
  def setData(o: js.Object, f: js.Function = callback) = {
    val current = WXGlobal.getCurrentPages().last
    current.setData(o,f)
  }

  def login(): Future[Int] = {
    val p = Promise[Int]()
    val cb = () => p.success(0)
    wx.login(literal(success = cb))
    p.future
  }

  def getUserInfo(withCredentials: Boolean = false,lang: String ="en"): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val cb = (res: js.Dynamic) => p.success(res.userInfo)
    wx.getUserInfo(literal(success = cb))
    p.future
  }
}
