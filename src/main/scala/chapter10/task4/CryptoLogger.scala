package chapter10.task4

/**
  * Упражнение 4 из главы 10
  */
class CryptoLogger(override val base: Int) extends CaesarLogger {
  def this(){ this(3) }
}

