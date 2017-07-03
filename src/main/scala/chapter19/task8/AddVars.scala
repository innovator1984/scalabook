package chapter19.task8

import scala.collection.mutable.{Map => mMap}
import scala.math.pow
import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 8 из главы 19
  */
class ExprParser extends RegexParsers {

  // хронилище для переменных
  private val varStore = mMap.empty[String, Double]

  // переменные
  def vars: Parser[String] =
    """[a-zA-Z]+""".r

  // число
  def number: Parser[Double] =
    """[0-9]+(\.[0-9]+)?""".r ^^ (_.toDouble) | vars ^^ (varStore.getOrElse(_, 0))

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

  // присвоение переменной
  def varCreate: Parser[Double] = vars ~ "=" ~ expr ^^ {
    case v ~ _ ~ e => varStore += (v -> e); e
  }

  // полное выражение
  def expr: Parser[Double] = thirdPriority

  // выполнение присвоения или вычисления операции. Результат вычисления послдняя строка
  def code: Parser[Double] = rep(varCreate | expr) ^^ (_.last)

  def apply(input: String): Double = parseAll(code, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}

object AddVars extends App {

  val parser = new ExprParser

  // z = 0
  val code =
    """
      |x=111
      |y=222
      |x+y+z
      |
      |""".stripMargin

  println(parser(code))

}
