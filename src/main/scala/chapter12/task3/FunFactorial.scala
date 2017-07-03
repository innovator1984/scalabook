package chapter12.task3

/**
  * Упражнение 3 из главы 12
  */
object FunFactorial {
  def factorial(x: Int): Int = (1 to x).reduceLeft(_ * _)
}

object TestFunFactorial extends App {

  import FunFactorial._

  val value = factorial(4)
  println(value)
}
