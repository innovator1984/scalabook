package chapter9.task4

import scala.io.Source

/**
  * Упражнение 4 из главы 9
  */
object OperationWithInt extends  App{

  val arr = Source.fromFile("src/main/resource/onlyInt.txt","UTF-8").mkString.split(",").map(_.toInt)
  println((arr.sum, arr.min, arr.max, arr.sum/arr.length))


}
