package chapter17.task1

/**
  * Упражнение 1 из главы 17
  */
class Pair[T, S](first: T, second: S) {

  def swap = new Pair[S, T](second,first)

  override def toString: String = s"""Pair($first,$second)"""

}

object TestPair extends App {

  val pair = new Pair[String, Int]("Hello world", 25)

  println(pair)
  println(pair.swap)

}
