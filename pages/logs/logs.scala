import scala.scalajs.js
import js.Dynamic.literal

object Logs extends js.Object {
  def onLoad(): Unit = {
    println("page logs loaded...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Logs)
  }
}
