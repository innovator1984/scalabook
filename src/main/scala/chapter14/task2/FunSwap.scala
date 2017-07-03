package chapter14.task2

/**
  * Упражнение 2 из главы 14
  */
object FunSwap {

  def swap(tuple: (Int, Int)): (Int, Int) =
    tuple match {
      case (x, y) => (y, x)
    }

}

object TestFunSwap extends App {

  import FunSwap._

  println(swap(1, 2))
}
