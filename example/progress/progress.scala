import scala.scalajs.js
import js.Dynamic.literal

object Progress extends js.Object {
  val data = literal(progress = 0, disabled = false)

  def next(): Unit = {
    if (this.data.progress.asInstanceOf[Int] >= 100) {
      Wechat.setData(literal(disabled=false))
    }
    else {
      val progress = this.data.progress.asInstanceOf[Int] + 1
      Wechat.setData(literal(progress=progress))
      val cb = () => { next() }
      WXGlobal.setTimeout(cb,20)
    }
  }

  def upload(): Unit = {
    if (!this.data.disabled.asInstanceOf[Boolean]) {
      Wechat.setData(literal(progress=0,disabled=true))
      next()
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Progress)
  }
}
