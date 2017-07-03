package chapter15.task6

/**
  * Упражнение 6 из главы 15
  */
object WorkWithVolatile {

  /* 1. Чтение и запись этого поля производится атомарно
  *  2. Измененение значение этого поля становится сразу достпно для всех потоков
  **/

  @volatile
  var check = false

}

object TestWorkWithVolatile extends App {

  val th1 = new Thread(
    () => {
      println("thread1 is sleeping")

      Thread.sleep(5000)

      println("thread1 is working")
      WorkWithVolatile.check = true
    }
  )

  val th2 = new Thread(
    () => {

      println("thread2 is working")

      while (!WorkWithVolatile.check)
        Thread.sleep(10)

      println("value check is true")
    }
  )

  th1.start()
  th2.start()

}
