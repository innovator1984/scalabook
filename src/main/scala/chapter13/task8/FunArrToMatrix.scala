package chapter13.task8

/**
  * Упражнение 8 из главы 13
  */
object FunArrToMatrix {

  def arrToMatrix(arr: Array[Double], columns: Int): Array[Array[Double]] =
    arr.grouped(columns).toArray[Array[Double]]

}

object TestFunArrToMatrix extends App {

  import FunArrToMatrix._

  val arr = Array(1d, 2d, 3d, 4d, 5d, 6d)
  println(arrToMatrix(arr, 3).map(_.mkString("[", ",", "]")).mkString("\n"))
}
