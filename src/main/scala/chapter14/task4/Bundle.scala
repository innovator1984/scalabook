package chapter14.task4

/**
  * Упражнение 4 из главы 14
  */
case class Bundle(description: String, discount: Double, items: Item*) extends Item
