package chapter19.task1

import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 1 из главы 19
  */
object AddExprToParser extends App {

  val calc = new ExprParser

  val test1 = "1 + 2"
  val test2 = "1 + 2 * 3"
  val test3 = "(10 + 2 * 3) / 2"
  val test4 = "(1 + 2) * 3"
  val test5 = "3.2 % 2.3"

  println(test1 + " = " + calc(test1))
  println(test2 + " = " + calc(test2))
  println(test3 + " = " + calc(test3))
  println(test4 + " = " + calc(test4))
  println(test5 + " = " + calc(test5))

}

class ExprParser extends RegexParsers {

  // числа
  def number: Parser[Double] =
    """[0-9]+(\.[0-9]+)?""".r ^^ (_.toDouble)

  // число или выражение
  def factor: Parser[Double] = number | "(" ~> expr <~ ")"

  // части вырожения с высоким приоритетом выполнения (*, /)
  def term: Parser[Double] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
    case number ~ list => (number /: list) {
      case (x, "*" ~ y) => x * y
      case (x, "/" ~ y) => x / y
      case (x, "%" ~ y) => x % y
    }
  }

  // выражение, состоящее из равноприоритетных частай (+, -)
  def expr: Parser[Double] = term ~ rep(("+" | "-") ~ term) ^^ {
    case term ~ list => (term /: list) {
      case (x, "+" ~ y) => x + y
      case (x, "-" ~ y) => x - y
    }
  }

  // для удобства выполнения и обработки ошибок
  def apply(input: String): Double = parseAll(expr, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}

