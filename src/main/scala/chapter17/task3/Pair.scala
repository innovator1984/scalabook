package chapter17.task3

/**
  * Упражнение 3 из главы 17
  */
class Pair[T, S](val first: T, val second: S) {

  def swap(pair: Pair[T, S]): Pair[S, T] = new Pair[S, T](pair.second, pair.first)

  override def toString: String = s"""Pair(first="$first", second="$second")"""

}

object TestPair extends App {

  val testPair = new Pair[String, Int]("Hello", 115)

  println(testPair)
  println(testPair.swap(testPair))
}
