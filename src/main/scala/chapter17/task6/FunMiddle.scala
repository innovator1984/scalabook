package chapter17.task6

/**
  * Упражнение 6 из главы 17
  */
object FunMiddle {

  def middle[T](input: Iterable[T]): T = input.toSeq(input.size / 2)

}

object TestFunMiddle extends App {

  import FunMiddle._

  println(middle("World"))
  println(middle(Seq(1,2,3,4,5,6,7)))

}