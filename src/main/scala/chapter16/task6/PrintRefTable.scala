package chapter16.task6

import scala.xml.XML

/**
  * Упражнение 6 из главы 16
  */
object PrintRefTable extends App {

  val xHtml = XML.loadFile("src/main/resource/xHtmlExample.xhtml")
  val references = xHtml \\ "a" map { a => (a.text.mkString, a.attribute("href").getOrElse("")) }
  val refTable = {
    <table>
      <caption>Таблица ссылок</caption>
      <tr>
        <th>Название</th>
        <th>Ссылка</th>
      </tr>{references.map(nameRef => {
      <tr>
        <td>{nameRef._1}</td>
        <td>{nameRef._2}</td>
      </tr>
    })}
    </table>
  }

  println(refTable)

}
