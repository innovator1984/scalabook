package chapter11.task5

import scala.collection.mutable.ArrayBuffer

/**
  * Упражнение 5 из главы 11
  */
class Table extends HtmlElement {

  val body = ArrayBuffer(new Row())
  private var currentRow = 0

  def |(value: String):Table = {
    body(currentRow) += new Column(value)
    this
  }

  def ||(value: String): Table = {
    currentRow +=1
    body += new Row()
    body(currentRow) += new Column(value)
    this
  }

  override def toHtml(): String = "<table>" + body.mkString + "</table>"

}

object Table { def apply(): Table = new Table() }

class Column(val value: String) {
  override def toString: String = "<td>" + value + "</td>"
}


class Row(val columns: ArrayBuffer[Column]) {

  def this() {
    this(ArrayBuffer.empty[Column])
  }

  def +=(column: Column):Row = {
    columns += column
    this
  }

  override def toString: String = columns.mkString("<tr>", "", "</tr>")

}

object TestTable extends App {
  
  val table = Table() | "ID" | "NAME" || "1" | "Java" || "2" | "Scala"

  println(table.toHtml())
  
}
