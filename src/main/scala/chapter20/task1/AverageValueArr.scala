package chapter20.task1

/**
  * Упражнение 1 из главы 20
  */
object AverageValueArr extends App {

  val n = 99999999
  val testArray = new RandomIntArray(n).array
  val ts = System.currentTimeMillis()

  // однопоточное вычисление результата
  println(testArray.sum / testArray.length)
  println(s"time of work: ${System.currentTimeMillis() - ts} millis.")

}
