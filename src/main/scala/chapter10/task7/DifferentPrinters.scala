package chapter10.task7

/**
  * Упражнение 7 из главы 10
  */
object DifferentPrinters extends App {

  class SimplePrinter extends Printer {
    override def print(obj: Any): Unit = println(obj)
  }

  val numberPrinter = new SimplePrinter with NumberPrinter
  numberPrinter.print(10d)

  val mapPrinter = new SimplePrinter with MapPrinter
  mapPrinter.print(Map("name"->"Alex", "age"->25))

}
