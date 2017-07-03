package chapter16.task4

import scala.xml.XML

/**
  * Упражнение 4 из главы 16
  */
object ReadXml extends App {

  val xHtml = XML.loadFile("src/main/resource/xHtmlExample.xhtml")
  val img = xHtml \\ "img"

  img.filter(_.attribute("alt") match { case None => true; case _ => false })
    .foreach(println)
}
