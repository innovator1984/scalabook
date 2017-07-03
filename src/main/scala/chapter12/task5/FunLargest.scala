package chapter12.task5

/**
  * Упражнение 5 из главы 12
  */
object FunLargest {
  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int =
    inputs.map(fun(_)).max
}

object TestFunLargest extends App {

  import FunLargest._
  val value = largest(x => 10 * x - x * x, 1 to 10)
  println(value)
}