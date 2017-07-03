package chapter10.task2

/**
  * Упражнение 2 из главы 10
  */
object ComparePoint extends App {

  import java.awt.Point
  val point1 = new Point(10,10) with OrderedPoint
  val point2 = new Point(20,10) with OrderedPoint
  val point3 = new Point(10,20) with OrderedPoint
  val point4 = new Point(5,20) with OrderedPoint
  println(point1)
  println(point2)
  println(point3)
  println(point4)

  println(point1 < point2)
  println(point1 < point3)
  println(point1 < point4)

}

