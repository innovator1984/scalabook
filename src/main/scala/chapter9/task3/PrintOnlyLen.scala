package chapter9.task3

import scala.io.Source

/**
  * Упражнение 3 из главы 9
  */
object PrintOnlyLen extends App {

  Source.fromFile("src/main/resource/textFile.txt").mkString.split("""\s""").filter(_.length == 4).foreach(println)

}
