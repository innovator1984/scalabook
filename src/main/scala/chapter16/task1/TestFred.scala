package chapter16.task1

/**
  * Упражнение 1 из главы 16
  */
object TestFred extends App {

  println(<fred/>.getClass.getTypeName)
  /*
  * (0) вызывают метод apply(0),
  * который возвращает 0 элемент последовательности мз одного элемента
  * */
  println(<fred/> == <fred/> (0))
  println(<fred/> == <fred/> (0)(0))

}
