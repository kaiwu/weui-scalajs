import scala.scalajs.js
import js.Dynamic.literal

object Uploader extends js.Object {
  val data = literal(files=js.Array[String]())

  def chooseImage(e: WxEvent): Unit = {
    val done = (res: js.Dynamic) => {
      val files = this.data.files.concat(res.tempFilePaths)
      Wechat.setData(literal(files=files))
    }
    wx.chooseImage(literal(
      sizeType = js.Array("original","compressed"),
      sourceType = js.Array("album","camera"),
      success = done
    ))
  }

  def previewImage(e: WxEvent): Unit = {
    wx.previewImage(literal(
      current = e.currentTarget.id,
      urls = this.data.files
    ))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Uploader)
  }
}
