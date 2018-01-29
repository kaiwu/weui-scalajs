import scala.scalajs.js
import js.Dynamic.literal
 
object Index extends js.Object {
  class Item (
    val id: String,
    val name: String,
    val open: Boolean,
    val pages: js.Array[String]
  ) extends js.Object

  val data = literal(list= js.Array[Item] (
    new Item("form","表单",false,js.Array[String]("button", "list", "input", "slider", "uploader")),
    new Item("widget","基础组件",false, js.Array[String]("article", "badge", "flex", "footer", "gallery", "grid", "icons", "loadmore", "panel", "preview", "progress")),
    new Item("feedback","操作反馈",false, js.Array[String]("actionsheet", "dialog", "msg", "picker", "toast")),
    new Item("nav","导航相关",false, js.Array[String]("navbar", "tabbar")),
    new Item("search","搜索相关",false, js.Array[String]("searchbar"))
  ))

  def kindToggle (e: WxEvent): Unit = {
    val toggle = (i: Item) => {
      val open = if (e.currentTarget.id == i.id) !i.open else false
      new Item(i.id,i.name,open,i.pages)
    }
    val list = this.data.list.map(toggle)
    Wechat.setData(literal(list=list))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Index)
  }
}
