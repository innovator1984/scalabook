package chapter12.task6

/**
  * Упражнение 6 из главы 12
  */
object FunLargestAt {
  def largestAt(fun: (Int)=>Int, inputs: Seq[Int]): Int =
  inputs.map(v => (v,fun(v))).maxBy(_._2)._1
}

object TestFunLargestAt extends App {

  import FunLargestAt._
  val value = largestAt(x => 10 * x - x * x, 1 to 10)
  println(value)
}
