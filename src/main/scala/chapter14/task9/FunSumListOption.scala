package chapter14.task9

/**
  * Упражнение 9 из главы 14
  */
object FunSumListOption {

  def sumList(list: List[Option[Int]]): Int = list.map(_.getOrElse(0)).sum

}

object TestFunSumListOption extends App {

  import FunSumListOption._

  val testList = List(Some(3), Some(7), None, Some(3), None, Some(1))
  println(sumList(testList))
}
