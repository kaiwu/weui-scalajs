import scala.scalajs.js
import js.Dynamic.literal

object Progress extends js.Object {
  val data = literal(progress = 0, disabled = false)

  def next(progress: Int): Unit = {
    if (progress >= 100) {
      println("progress is " + this.data.progress)
      Wechat.setData(literal(disabled=false))
    }
    else {
      Wechat.setData(literal(progress=progress))
      val cb = () => { next(progress+1) }
      WXGlobal.setTimeout(cb,20)
    }
  }

  def upload(): Unit = {
    Wechat.setData(literal(progress=0,disabled=true))
    next(0)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Progress)
  }
}
