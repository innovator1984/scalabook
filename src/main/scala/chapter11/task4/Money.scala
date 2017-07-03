package chapter11.task4

/**
  * Упражнение 4 из главы 11
  */
class Money(val dollar: Int, val cent: Int) {

  def +(that: Money): Money = {
    val result = (("" + dollar + "." + cent).toDouble + ("" + that.dollar + "." + that.cent).toDouble).toString
      .split("""\.""")
      .map(_.toInt)

    Money(result(0),result(1))
  }

  def -(that: Money): Money = {
    val result = (("" + dollar + "." + cent).toDouble - ("" + that.dollar + "." + that.cent).toDouble).toString
      .split("""\.""")
      .map(_.toInt)

    Money(result(0),result(1))
  }

  def ==(that: Money): Boolean = if (dollar == that.dollar && cent == that.cent) true else false

  override def toString: String = "Money("+ dollar +","+ cent +")"

}

object Money { def apply(dollar: Int, cent: Int): Money = new Money(dollar, cent) }

object TestMoney extends App {

  val money1 = Money(1,75) + Money(0,50)
  val money2 = Money(1,75) - Money(0,50)
  println(money1 == Money(2,25))
  println(money2 == Money(1,25))
  println(money1 == money2)

}

