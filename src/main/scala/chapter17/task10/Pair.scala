package chapter17.task10

/**
  * Упражнение 10 из главы 17
  */
class Pair[S, T](var first: S, var second: T)(implicit ev: S <:< T) {

  def swap(newFirst: S, newSecond: S): Pair[S, T] = {
    first = newFirst
    second = newSecond
    this
  }

}

object TestPair extends App {

  val test = new Pair[Double, AnyVal](1d, 2d)
  println (test.swap(7d,10d).first)
  println (test.swap(7d,10d).second)

}
