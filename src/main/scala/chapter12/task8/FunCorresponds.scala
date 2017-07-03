package chapter12.task8

/**
  * Упражнение 8 из главы 12
  */
object FunCorresponds {

  def corresronds(input: Seq[String]): (Seq[Int]) => Seq[Boolean] = (size) =>
    (input zip size).map(t => t._1.length == t._2)
}

object TestFunCorresponds extends App {

  import FunCorresponds._

  println(corresronds(Array("Hello", "world"))(Array(5, 5)))
  println(corresronds(Array("Hello", "world"))(Array(5, 4)))
}
