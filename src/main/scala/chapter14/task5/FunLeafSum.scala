package chapter14.task5

/**
  * Упражнение 5 из главы 14
  */
object FunLeafSum {

  def leafSum(tree: List[Any]): Int =
    (for (leaf <- tree) yield
      leaf match {
        case l: Int => l
        case v: List[Any] => leafSum(v)
      }).sum


}

object TetFunLeafSum extends App {

  import FunLeafSum._

  /*
  * Дерево для теста
  *      .
  *     /|\
  *    . 2 .
  *   / \  |
  *  3   8 5
  *
  * */
  val tree = List(List(3, 8), 2, List(5))

  println("Sum of all leaf: " + leafSum(tree))
}
