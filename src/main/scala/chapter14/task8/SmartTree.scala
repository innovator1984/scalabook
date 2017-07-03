package chapter14.task8

/**
  * Упражнение 8 из главы 14
  */
sealed abstract class SmartTree

case class Leaf(value: Int) extends SmartTree

case class Node(op: Char, elem: SmartTree*) extends SmartTree

