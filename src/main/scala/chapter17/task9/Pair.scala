package chapter17.task9

/**
  * Упражнение 9 из главы 17
  */
class Pair[T](val first: T, val second: T) {

  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)

}

class NastyDoublePair(first: Double, second: Double) extends Pair[Double](first, second) {

  import scala.math.sqrt

  override def replaceFirst(newFirst: Double): Pair[Double] = new NastyDoublePair(sqrt(newFirst), second)

}

object TestNastyDoublePair extends App {

  /*
  * Если объявить класс Pair[T] а не (Pair[+T]) то не козможно вызвать переопределённый метод,
  * выражение val test: Pair[Any] = new NastyDoublePair(1d,2d) не компилируется и соответственно
  * вызов test.replaceFirst("Hello") невозможен.
  *
  * Если объявить класс Pair[+T] то метод replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
  * не компилитуется, потому что + говорит о ковариантности параметра, который стоит на конртвариантной позикии
  *
  * */





}
