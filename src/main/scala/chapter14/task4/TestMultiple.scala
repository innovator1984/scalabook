package chapter14.task4


/**
  * Упражнение 4 из главы 14
  */
object TestMultiple extends App {

  // Округление до указанного знака после запятой
  def round(value: Double, count: Int): Double = {
    val mlt = scala.math.pow(10, count.toDouble)
    scala.math.round(value * mlt) / mlt
  }

  def price(item: Item): Double = item match {
    case Product(_, price) => price
    case Bundle(_, discount, insideItems@_*) => round(insideItems.map(price).sum - discount, 2)
    case Multiple(count, insideItem) => round(price(insideItem) * count.toDouble, 2)
  }

  // Продукты
  val toaster = Product("Blackwell Toaster", 29.95)
  val book = Product("Book about Scala", 30.25)
  val milk = Product("Nature milk", 10.35)

  // Пакеты
  val mondaySale = Bundle("Monday sale", 0.33, book, milk)

  // Мультисборки
  val mltProduct = Multiple(10, toaster)
  val mltBundle = Multiple(5, mondaySale)

  println("--------- Products ---------")
  println(toaster.description + ": " + price(toaster))
  println(book.description + ": " + price(book))
  println(milk.description + ": " + price(milk))

  println("--------- Bundles ---------")
  println(mondaySale.description + ": " + price(mondaySale))

  println("--------- Multiples ---------")
  println("Count products: " + price(mltProduct))
  println("Count bundles: " + price(mltBundle))
}
