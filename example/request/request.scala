import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.ExecutionContext.Implicits.global

//implicit
import Wechat.errorCallback

object Request extends js.Object {
  val data = literal(motto="hello world", userInfo=literal())

  def onLoad(): Unit = {
    val info = for {
      msg  <- Wechat.login{}
      info <- Wechat.getUserInfo(false,"en"){}
    } yield info

    Wechat.setData(info)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Request)
  }
}


