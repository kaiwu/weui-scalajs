import scala.scalajs.js
import js.Dynamic.literal
import js.Dynamic.{global => g}

object app extends js.Object {
  g.PouchDB = g.require("lib/pouchdb-6.4.3.min.js").asInstanceOf[js.Dynamic]
  g.require("lib/pouchdb.memory.min.js")
  val db = js.Dynamic.newInstance(g.PouchDB)("local",literal(adapter = "memory"))
  val globalData = literal(hasLogin = false, db = db)

  def onLaunch(): Unit = {
    val cb = (err: js.Dynamic, doc: js.Dynamic) => {println("doc is saved")}
    this.db.put(literal(_id = "mydoc",motto = "hello pouchdb"),literal(),cb)
  }
  def onShow(): Unit = {
    println("App Show")
  }
  def onHide(): Unit = {
    println("App Hide")
  }
  def getDb(): js.Dynamic = this.globalData.db
}

object Main {
  def main(args: Array[String]): Unit = {
    App(app)
  }
}
