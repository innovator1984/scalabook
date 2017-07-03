package chapter14.task6

/**
  * Упражнение 6 из главы 14
  */
object FunBinaryTree {

  def leafSum(binaryTree: BinaryTree): Int = binaryTree match {
      case Leaf(v) => v
      case Node(l, r) => leafSum(l) + leafSum(r)
  }

}

object TestFunBinaryTree extends App {

  import FunBinaryTree._

  /*
  * Бинарное дерево
  *
  *             .
  *            / \
  *           .   21
  *          / \
  *         1   .
  *            / \
  *           .   17
  *          / \
  *         3   7
  *
  * */
  val binaryTree = Node(Node(Leaf(1), Node(Node(Leaf(3), Leaf(7)), Leaf(17))), Leaf(21))
  println("Sum of all leaf of the binary tree: " + leafSum(binaryTree))

}
