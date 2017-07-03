package chapter9.task6

import scala.io.Source

/**
  * Упражнение 6 из главы 9
  */
object FindLinesIntoQuotes extends App {

 """".+"""".r.findAllIn(Source.fromFile("src/main/resource/textFile.txt").mkString).foreach(println)

}
