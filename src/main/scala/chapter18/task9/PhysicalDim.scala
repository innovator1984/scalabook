package chapter18.task9

/**
  * Упражнение 9 из главы 18
  */

abstract class Dim[T](val value: Double, val name: String) {

  this: T =>

  protected def create(v: Double): Dim[T]

  def +(other: Dim[T]): Dim[T] = create(value + other.value)

  override def toString: String = value + " " + name

}

class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  override protected def create(v: Double): Dim[Seconds] = new Seconds(v)
}

object PhysicalDim extends App {

  val sec15 = new Seconds(15)
  val sec20 = new Seconds(20)

  println(sec15 + " + " + sec20 + " = " + (sec15 + sec20))

}
