package chapter13.task4

/**
  * Упражнение 4 из главы 13
  */
object FunGetIndexString {

  def getIndex(strings: Array[String], dict: Map[String, Int]): Array[Int] = {
    strings.map(dict.get).flatMap(_.toArray[Int])
  }

}

object TestFunGetIndexString extends App {

  import FunGetIndexString._

  val strings = Array("Tom", "Fred", "Harry")
  val dict = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

  println(getIndex(strings, dict).mkString("(", ",", ")"))

}