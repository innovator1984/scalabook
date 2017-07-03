package chapter18.task8

/**
  * Упражнение 8 из главы 18
  */
object PrintValues extends App {

  object Increment {
    def apply(value: Int): Int = value + 1
  }

  object Square {
    def apply(value: Int): Int = value * value
  }

  def printValues(f: {def apply(value: Int): Int}, to: Int, from: Int): Unit =
    println((to to from).map(f(_)).mkString(" "))


  printValues(Increment, 1, 9)
  printValues(Square, 1, 9)
  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6)

}
