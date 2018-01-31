import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.ExecutionContext.Implicits.global

object Request extends js.Object {
  val data = literal(motto="hello world", userInfo=literal())

  def onLoad(): Unit = {
    val done = for {
      login <- Wechat.login()
      user <- Wechat.getUserInfo()
      done <- Wechat.setData(literal(userInfo = user))
    } yield done

  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Request)
  }
}


