import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.{Future,Promise}

object Wechat {
  type Callback = () => Unit 
  implicit val callback: Callback = () => {}

  def andThen(f: =>Unit): Unit = f

  def setData(o: js.Object,f: Callback = callback) = {
    val current = WXGlobal.getCurrentPages().last
    current.setData(o,f)
    this
  }

  def login(implicit c: Callback): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val scb = (ret: js.Dynamic) => p.success(ret)
    val fcb = () => p.failure(js.JavaScriptException("failed wx.login"))
    wx.login(literal(success = scb, fail = fcb, complete = c))
    p.future
  }

  case class GetUserInfoOption(withCredentials: Boolean,lang: String)
  implicit val getUserInfoOption = GetUserInfoOption(false,"en")
  def getUserInfo(implicit o: GetUserInfoOption, c: Callback): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val scb = (ret: js.Dynamic) => p.success(ret.userInfo)
    val fcb = () => p.failure(js.JavaScriptException("failed wx.getUserInfo"))
    wx.getUserInfo(literal(withCredentials = o.withCredentials,
                           lang = o.lang,
                           success = scb,
                           fail = fcb,
                           complete = c))
    p.future
  }
}
