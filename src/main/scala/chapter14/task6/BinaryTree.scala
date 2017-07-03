package chapter14.task6

/**
  * Упражнение 6 из главы 14
  */
sealed abstract class BinaryTree

case class Leaf(value: Int) extends BinaryTree

case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
