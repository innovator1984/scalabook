package chapter13.task5

/**
  * Упражнение 5 из главы 13
  */
object FunLikeMkString {

  def likeMkString(arr: Iterable[Any]): String =
    arr.map(_.toString).reduceLeft(_ + _)

  def likeMkString(arr: Iterable[Any], sep: String): String =
    arr.map(_.toString).reduceLeft(_ + sep + _)

  def likeMkString(arr: Iterable[Any], before: String, sep: String, after: String): String =
    before + arr.map(_.toString).reduceLeft(_ + sep + _) + after
}

object TestFunLikeMkString extends App {

  import FunLikeMkString._

  val testArr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(likeMkString(testArr))
  println(likeMkString(testArr, ","))
  println(likeMkString(testArr, "[", ",", "]"))
}