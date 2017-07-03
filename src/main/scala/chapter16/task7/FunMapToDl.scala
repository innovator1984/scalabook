package chapter16.task7

import scala.xml.NodeSeq

/**
  * Упражнение 7 из главы 16
  */
object FunMapToDl {
  def mapToDl(mapDl: Map[String, String]): NodeSeq =
    mapDl.map(kv => {<dl><dt>{kv._1}</dt><dd>{kv._2}</dd></dl>}).toSeq

}

object TestFunMapToDl extends App {

  import FunMapToDl._

  println(mapToDl(Map("A" -> "1", "B" -> "2")))
}