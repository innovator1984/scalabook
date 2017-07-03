package chapter15.task4

import scala.annotation.varargs

/**
  * Упражнение 4 из главы 15
  */
class ForJava {

  @varargs def sum(args: Int*): Int = args.sum // правильный вариант

  def sum2(@varargs args: Int*): Int = args.sum // этот ваниант не работате

}

