package chapter15.task1

import org.junit.{Assert, Test}

/**
  * Упражнение 1 из главы 15
  */
class TestWithJUnit {

  @Test
  def Test1(): Unit = {
    val product = new Product("Book about Scala", 30.95)
    Assert.assertTrue(product.upPrice(10d) == 40.95)
  }

  @Test(timeout = 100000)
  def Test2(): Unit = {
    val product = new Product("Book about Scala", 30.95)
    Assert.assertTrue(product.upPrice(-10d) == 20.95)
  }

  @Test(timeout = 100000, expected = classOf[MatchError])
  def Test3(): Unit = {
    val product = new Product("Book about Scala", 30.95)
    product.price match {
      case 40.95 => println("bam")
    }
  }

}
