package chapter13.task3

/**
  * Упражнение 3 из главы 13
  */
object DellZeroFromList {

  def dellZero(list: List[Int]): List[Int] = list.filter(_ > 0)

}

object TestDellZeroFromList extends App {

  import DellZeroFromList._

  val testList = List(1, 4, 0, 4, 2, 0, 5, 8, 0, 3, 5, 2, 7)
  println(dellZero(testList))
}