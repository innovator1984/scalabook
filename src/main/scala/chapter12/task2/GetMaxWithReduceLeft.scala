package chapter12.task2

/**
  * Упражнение 2 из главы 12
  */
object GetMaxWithReduceLeft extends App {

  val testArr = Array(1,2,5,3,6,7,4,0)

  val maxValue = testArr.reduceLeft((x1,x2) => if (x1 >= x2) x1 else x2)

  println(maxValue)

}
