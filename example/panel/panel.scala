import scala.scalajs.js
import js.Dynamic.literal

object Panel extends js.Object {
  def onLoad(): Unit = {
    Wechat.setData(literal(icon20=Base64.icon20,icon60=Base64.icon60))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Panel)
  }
}
