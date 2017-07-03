package chapter10.task4

/**
  * Упражнение 4 из главы 10
  */
trait CaesarLogger extends Logger {

  val base: Int

  def log(msg: String): Unit = {

    println(msg.toCharArray.map(_+base).map(_.toChar).mkString)

  }

}
