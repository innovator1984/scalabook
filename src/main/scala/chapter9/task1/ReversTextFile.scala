package chapter9.task1

import java.io.PrintWriter

import scala.io.Source

/**
  * Упражнение 1 из главы 9
  */
object ReversTextFile extends App {

  val sourceFile = "src/main/resource/textFile.txt"
  val resultFile = "src/main/resource/resultReversTextFile.txt"

  val writer = new PrintWriter(resultFile,"UTF-8")

  val source = Source.fromFile(sourceFile,"UTF-8")
  source.getLines().toArray.reverse.map(_.toString).foreach(line => writer.println(line))

  source.close()
  writer.close()



}
