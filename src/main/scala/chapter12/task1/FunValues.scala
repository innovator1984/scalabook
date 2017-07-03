package chapter12.task1

/**
  * Упражненияе 1 из главы 12
  */
object FunValues {

  def values(fun: (Int) => Int, low: Int, hight: Int): Seq[(Int,Int)] =
    (low to hight).map(x => (x, fun(x)))

}

object TestFunValues extends App {

  import FunValues._

  val seq = values(x => x * x, -5, 5)
  println(seq)
}
