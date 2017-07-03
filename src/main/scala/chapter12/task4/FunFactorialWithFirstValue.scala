package chapter12.task4

/**
  * Упражнение 4 из главы 12
  */
object FunFactorialWithFirstValue {
  def factorial(x: Int): Int = (1 to x).foldLeft(1)(_ * _)
}

object TestFunFactorialWithFirstValue extends App {

  import FunFactorialWithFirstValue._
  val value = factorial(-1)
  println(value)
}
