package chapter13.task1

import scala.collection.immutable.SortedSet

/**
  * Упражнение 1 из главы 13
  */
object FunIndexOfChar {

  def indexes(text: String): Map[Char, SortedSet[Int]] = {
    text.zipWithIndex
      .groupBy(_._1)
      .map(ch => ch._1 -> SortedSet(ch._2.map(_._2): _*))
  }
}

object TestFunIndexOfChar extends App {

  import FunIndexOfChar._

  val text = "Mississippi"
  println(indexes(text))
}