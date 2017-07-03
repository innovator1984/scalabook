package chapter19.task2

import scala.util.parsing.combinator.RegexParsers
import scala.math.pow

/**
  * Упражнение 2 из главы 19
  */
object AddPowToParser extends App {

  val calc = new ExprParser

  val test = "4 ^ 2 ^ 3"

  println(calc(test))

}

class ExprParser extends RegexParsers {

  // число
  def number: Parser[Double] =
    """[0-9]+(\.[0-9]+)?""".r ^^ (_.toDouble)

  // возведение в степень
  def firstPriority: Parser[Double] = (number | "(" ~> expr <~ ")") ~ rep("^" ~ (number | "(" ~> expr <~ ")")) ^^ {
    case n ~ list => ((n :: list.map(_._2)) :\ 1d) (pow)
  }

  // умножение и деление
  def secondPriority: Parser[Double] = firstPriority ~ rep(("*" | "/" | "%") ~ firstPriority) ^^ {
    case f ~ list => (f /: list) {
      case (x, "*" ~ y) => x * y
      case (x, "/" ~ y) => x / y
      case (x, "%" ~ y) => x % y
    }
  }

  // сложение и вычитание
  def thirdPriority: Parser[Double] = secondPriority ~ rep(("+" | "-") ~ secondPriority) ^^ {
    case s ~ list => (s /: list) {
      case (x, "+" ~ y) => x + y
      case (x, "-" ~ y) => x - y
    }
  }

  // полное выражение
  def expr: Parser[Double] = thirdPriority

  def apply(input: String): Double = parseAll(expr, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}