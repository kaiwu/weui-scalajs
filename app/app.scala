import scala.scalajs.js
import js.Dynamic.literal

object app extends js.Object {
  def onLaunch(options: js.Object): Unit = {
      println("app launched...")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
