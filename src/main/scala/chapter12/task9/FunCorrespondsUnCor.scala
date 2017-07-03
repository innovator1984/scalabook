package chapter12.task9

/**
  * Упражнение 9 из главы 12
  */
object FunCorrespondsUnCor {

  def corresponds(input: Seq[String], size: Seq[Int]): Seq[Boolean] =
    (input zip size).map(t => t._1.length == t._2)
}

object TestFunCorrespondsUnCor extends App {

  import FunCorrespondsUnCor._

  println(corresponds(Array("Hello", "world"), Array(5, 5)))
  println(corresponds(Array("Hello", "world"), Array(5, 4)))

}
