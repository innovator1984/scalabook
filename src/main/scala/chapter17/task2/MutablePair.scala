package chapter17.task2

/**
  * Упражнение 2 из главы 17
  */
class MutablePair[T](var first: T, var second: T) {

  def swap: MutablePair[T] = {
    val tmp = first
    first = second
    second = tmp
    this
  }

  override def toString: String = s"""MutablePair(first="$first", second="$second")"""

}

object TestMutablePair extends App {

  val mutablePair = new MutablePair[String]("Hello", "world")

  println(mutablePair)
  mutablePair.swap
  println(mutablePair)

}
