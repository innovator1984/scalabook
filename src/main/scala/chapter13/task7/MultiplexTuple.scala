package chapter13.task7

/**
  * Упрыжнение 7 из главы 13
  */
object MultiplexTuple extends App {

  val fun = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 * v2
  }

  val seq = 1 to 9

  (seq zip seq).map(fun.tupled).foreach(println)
}
