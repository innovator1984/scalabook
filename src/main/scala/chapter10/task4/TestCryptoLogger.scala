package chapter10.task4

/**
  * Упражнение 4 из главы 10
  */
object TestCryptoLogger extends App {

  // с основанием 3
  val defaultLogger = new CryptoLogger()
  defaultLogger.log("ABCD")

  // с основанием -3
  val customLogger = new CryptoLogger(-3)
  customLogger.log("ABCD")

}
