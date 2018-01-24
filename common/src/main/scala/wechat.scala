import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSGlobalScope
object wechatapp extends js.Object {
  @JSName("App")
  def App (o: js.Object): Unit = js.native

  @JSName("Page")
  def Page (o: js.Object): Unit = js.native
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
