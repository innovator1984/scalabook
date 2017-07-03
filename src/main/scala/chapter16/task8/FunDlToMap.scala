package chapter16.task8

import scala.xml.NodeSeq

/**
  * Упражнение 8 из главы 16
  */
object FunDlToMap {

  def dlToMap(nodeSeq: NodeSeq): Map[String,String] =
  nodeSeq.map(dl => ((dl \ "dt").text, (dl \ "dd").text)).toMap
}

object TestFunDlToMap extends App {

  import FunDlToMap._

  val element = <dl><dt>A</dt><dd>1</dd></dl><dl><dt>B</dt><dd>2</dd></dl>

  println(dlToMap(element))
}
