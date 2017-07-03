package chapter14.task8

/**
  * Упраднение 8 из главы 14
  */
object FunSmartTree {

  def eval(smartTree: SmartTree): Double = smartTree match {
    case Leaf(v) => v
    case Node('+', elem@_*) => elem.map(eval).foldLeft(0d)(_ + _)
    case Node('-', elem@_*) => elem.map(eval).foldLeft(0d)(_ - _)
    case Node('*', elem@_*) => elem.map(eval).foldLeft(1d)(_ * _)
    case Node(_, elem@_*) => elem.map(eval).foldLeft(1d)(_ / _)
  }

}

object TestFunSmartTree extends App {

  import FunSmartTree._

  /*
  * Дерево для теста
  *      +
  *     /|\
  *    * 2 -
  *   / \  |
  *  3   8 5
  *
  * */

  val smartTree = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
  println("Value of smart tree: " + eval(smartTree))

}
