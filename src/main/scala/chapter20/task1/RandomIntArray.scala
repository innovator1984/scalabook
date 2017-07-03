package chapter20.task1

/**
  * Упражнение 1 из главы 20
  */
class RandomIntArray(val size: Int) {

  import scala.math.random

  val array: Array[Double] = (for (i <- 0 to size) yield random()).toArray

}
