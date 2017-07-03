package chapter14.task7

/**
  * Упражнение 7 из главы 14
  */
object FunTree {

  def leafSum(tree: Tree): Int = tree match {
      case Leaf(v) => v
      case Node(elem @ _*) => elem.map(leafSum).sum
    }

}

object TestFunTree extends App {

  import FunTree._
  /*
  * Дерево для теста
  *      .
  *     /|\
  *    . 2 .
  *   / \  |
  *  3   8 5
  *
  * */
  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  println("Sum of all leaf: " + leafSum(tree))

}
