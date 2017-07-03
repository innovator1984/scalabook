package chapter14.task7

/**
  * Упражнение 7 из главы 14
  */
sealed abstract class Tree

case class Leaf(value: Int) extends Tree

case class Node(elem: Tree*) extends Tree
