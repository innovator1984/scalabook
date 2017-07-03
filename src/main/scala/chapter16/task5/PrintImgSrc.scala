package chapter16.task5

import scala.xml.XML

/**
  * Упражнение 5 из главы 16
  */
object PrintImgSrc extends App {

  val xHtml = XML.loadFile("src/main/resource/xHtmlExample.xhtml")
  xHtml \\ "img" \\ "@src" foreach println
  // это сокращение от (xHtml \\ "img" \\ "@src").foreach(println)
}
