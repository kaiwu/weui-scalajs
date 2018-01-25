import scala.scalajs.js
import js.Dynamic.literal

object Index extends js.Object {
  val data = literal(motto="hello world", userInfo=literal())

  def bindViewTap(): Unit = wx.navigateTo(literal(url = "../logs/logs"))

  def onLoad(): Unit = {
    wx.login(literal(success=getUserInfo))
    lazy val getUserInfo = () => {wx.getUserInfo(literal(success=setUserInfo))}
    lazy val setUserInfo = (res: js.Dynamic) => {Wechat.setData(literal(userInfo = res.userInfo),cb)}
    lazy val cb = () => {println("avatar changed")}

    println("page index loaded...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Index)
  }
}
