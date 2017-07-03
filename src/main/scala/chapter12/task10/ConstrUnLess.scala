package chapter12.task10

/**
  * Упраднение 10 из главы 12
  */
object ConstrUnLess {
  def unless(condition: => Boolean): (=> Unit) => Unit = (action) =>
    if (!condition) action
}

object TestConstrUnLess extends App {

  import ConstrUnLess._

  if (3 < 2) {
    println("work `if`")
  }

  unless(3 < 2) {
    println("work `unless`")
  }

}