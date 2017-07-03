package chapter12.task7

/**
  * Упражнение 7 из главы 12
  */
object FunAdjustToPair {
  def adjustToPair(fun: (Int,Int) => Int)(value:(Int,Int)):Int =
    fun(value._1,value._2)
}

object TestFunAdjustToPair extends App {

  import FunAdjustToPair._

  val seq = (1 to 10) zip (11 to 20)
  println(seq)
  println(seq.map(adjustToPair(_ + _)))

}