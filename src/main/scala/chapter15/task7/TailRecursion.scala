package chapter15.task7

import scala.annotation.tailrec

/**
  * Упражнение 7 из главы 15
  */
class TailRecursion {

  import scala.math.pow

  /* Если убрать final то выдаёт ошибку, так как метод может быть переопределен.
  *  Можно также сделать метод private
  * */
  @tailrec final def action(count: Int, seq: Double*): Seq[Double] =
  if (count > 1) action(count - 1, seq.map(pow(_, count)): _*) else seq.map(pow(_, 1))

}

object TestTailRecursion extends App {

  println(new TailRecursion().action(5, 1d, 2d, 3d))
}
