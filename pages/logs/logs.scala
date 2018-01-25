import scala.scalajs.js
import js.Dynamic.literal

object Logs extends js.Object {
  val data = literal(logs = new js.Array[js.Date]())

  def onLoad(): Unit = {
    val cb = () => {println("show logs")}
    val logs = wx.getStorageSync("logs").getOrElse(new js.Array[js.Date]())

    Wechat.setData(literal(
      logs = logs.asInstanceOf[js.Array[js.Date]].map( d => {
        val date = new js.Date(d.valueOf())
        val year = date.getFullYear()
        val month = date.getMonth() + 1
        val day = date.getDate()

        val hour = date.getHours()
        val minute = date.getMinutes()
        val second = date.getSeconds()

        s"$year/$month/$day $hour:$minute:$second"
      })
    ),cb)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Logs)
  }
}
