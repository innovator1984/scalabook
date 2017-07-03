package chapter15.task10

/**
  * Упражнение 10 из главы 15
  */
object FactorialWithAssert {

  /*
  * Если компилировать код с опцией scalac -Xelide-below 2001 и более,
  * то проверка assert(n >=0 ) не вставляется в байткод. Метод assert помечен анотацией @elidable(ASSERTION)
  * Если компилировать поумолнынию (-Xelide-below 1000) то проверка выполняется и
  * на данном примере будет вылетать исключение java.lang.AssertionError: assertion failed.
  * */
  def factorial(n: Int): Long = {
    assert(n >=0 )
    (1 to n).product
  }

}

object TestFactorialWithAssert extends App {

  import FactorialWithAssert._

  println(factorial(-1))

}
