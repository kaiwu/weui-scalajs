import scala.util.{Success,Failure}
import scala.scalajs.js
import js.Dynamic.literal
import scala.concurrent.ExecutionContext.Implicits.global
import Wechat.callback
import Wechat.getUserInfoOption

object Request extends js.Object {
  val data = literal(motto="hello world", userInfo=literal())

  def onLoad(): Unit = {
    val info = for {
      msg <- Wechat.login
      info <- Wechat.getUserInfo
    } yield info
    info.onComplete {
      case Success(i) => Wechat.setData(literal(userInfo = i)).andThen { println("avatar changed") }
      case Failure(e) => println(e)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Request)
  }
}


