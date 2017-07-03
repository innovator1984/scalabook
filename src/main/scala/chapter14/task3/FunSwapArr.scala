package chapter14.task3

import scala.collection.mutable.ArrayBuffer

/**
  * Упражнение 3 из главы 14
  */
object FunSwapArr {

  def swap(arr: Array[Int]): Array[Int] =
    arr match {
      case Array(x, y, other@_*) => Array(y, x) ++ Array(other: _*)
    }

}

object TestFunSwapArr extends App {

  import FunSwapArr._

  println(swap(Array(1, 2, 3, 4, 5)).mkString("[", ",", "]"))
}
