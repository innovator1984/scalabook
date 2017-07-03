package chapter10.task1

/**
  * Упражнение 1 из главы 10
  */
object AddMethods extends App {

  import java.awt.Rectangle
  val rectangle = new Rectangle(10, 10, 50, 50)
  println(rectangle)
  rectangle.translate(10,10)
  println(rectangle)
  rectangle.grow(10,10)
  println(rectangle)

  import java.awt.geom.Ellipse2D
  val ellipse2D = new Ellipse2D.Double(10d, 10d, 50d, 50d) with RectangleLike
  println(ellipse2D)
  ellipse2D.translate(10,10)
  println(ellipse2D)
  ellipse2D.grow(10,10)
  println(ellipse2D)

}
