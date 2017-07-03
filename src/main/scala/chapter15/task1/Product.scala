package chapter15.task1

/**
  * Упражнение 1 из главы 15
  */
class Product(val description: String, var price: Double) {

  def upPrice(delta: Double): Double = {
    price += delta
    price
  }


}
