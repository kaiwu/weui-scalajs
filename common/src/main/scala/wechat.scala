import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSGlobal
class App extends js.Object {
  def onLaunch(options: js.Object): Unit = js.native
  def onShow(options: js.Object): Unit = js.native
  def onHide(): Unit = js.native
  def onError(msg: String): Unit = js.native
}

@js.native
@JSGlobal
object App extends js.Object {
  def apply(o: js.Object): App = js.native
}

@js.native
@JSGlobal
class Page extends js.Object {
  def setData(o: js.Object, f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
object Page extends js.Object {
  def apply(o: js.Object): Page = js.native
}

@js.native
@JSGlobalScope
object WXGlobal extends js.Object {
  def getApp(): App = js.native
  def getCurrentPages(): js.Array[Page] = js.native
}

@js.native
@JSGlobal("wx")
object wx extends js.Object {
  def login (o: js.Object): Unit = js.native
  def getUserInfo (o: js.Object): Unit = js.native
  def getStorageSync (key: String): js.Object = js.native
  def setStorageSync (key: String, data: js.Object): Unit = js.native
  def navigateTo(o: js.Object): Unit = js.native
}

object Wechat {
  def setData(o: js.Object, f: js.Function) = {
    val current = WXGlobal.getCurrentPages().last
    current.setData(o,f)
  }
}
