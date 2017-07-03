package chapter13.task2

/**
  * Упражнение 2 из главы 13
  */
object FunIndexOfCharWithList {

  def indexes(text: String): Map[Char, List[Int]] = {
    text.zipWithIndex
      .groupBy(_._1)
      .map(ch => ch._1 -> List(ch._2.map(_._2): _*))
  }

}

object TestFunIndexOfCharWithList extends App {

  import FunIndexOfCharWithList._

  val text = "Mississippi"
  println(indexes(text))
}