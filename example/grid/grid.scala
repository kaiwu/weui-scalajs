import scala.scalajs.js
import js.Dynamic.literal

object Grid extends js.Object {
  val data = literal(grids=js.Array[Int](0,1,2,3,4,5,6,7,8))
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Grid)
  }
}
