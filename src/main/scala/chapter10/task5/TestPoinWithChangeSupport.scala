package chapter10.task5

import java.awt.Point
/**
  * Упражнение 5 из главы 10
  */
object TestPoinWithChangeSupport extends App {

  val point = new Point with PropertyChangeSupport
  point.setLocation(1d,2d)
  println(point)

}
