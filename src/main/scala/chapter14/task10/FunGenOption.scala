package chapter14.task10

/**
  * Упражнение 10 из главы 14
  */
object FunGenOption {

  import scala.math._

  def f(x: Double): Option[Double] = if (x > 0) Some(sqrt(x)) else None

  def g(x: Double): Option[Double] = if (x != 1) Some(1 / (x - 1)) else None

  def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = (x: Double) => {

    Array(f(x), g(x)) match {
      case Array(None, _) => f(x)
      case Array(_, None) => g(x)
      case _ => g(x)
    }


  }

}

object TestFunGenOption extends App {

  import FunGenOption._

  val h = compose(f, g)

  println(h(2))
  println(h(1))
  println(h(0))

}
