package chapter9.task7

import scala.io.Source

/**
  * Упражнение 7 из главы 9
  */
object FilterNumbers extends App {

  println("[^0-9]+".r.findAllIn(Source.fromFile("src/main/resource/onlyInt.txt","UTF-8").mkString).mkString)

}
