package chapter19.task9

import scala.collection.mutable.{Map => mMap}
import scala.math.pow
import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 9 из главы 19
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

  // условия
  def condition: Parser[Boolean] = number ~ ("<" | ">" | "==" | "!=" | ">=" | "<=") ~ number ^^ {
    case x ~ ">" ~ y => x > y
    case x ~ "<" ~ y => x < y
    case x ~ ">=" ~ y => x >= y
    case x ~ "<=" ~ y => x <= y
    case x ~ "==" ~ y => x == y
    case x ~ "!=" ~ y => x != y
  }

  // конструкция if else
  def ifElse: Parser[Double] = "if" ~ "(" ~ condition ~ ") {" ~ code ~ "} else {" ~ code ~ "}" ^^ {
    case _ ~ _ ~ condition ~ _ ~ yes ~ _ ~ _ ~ _ if condition => yes
    case _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ no ~ _ => no
  }

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
  def code: Parser[Double] = rep(ifElse | varCreate | expr) ^^ (_.last)

  def apply(input: String): Double = parseAll(code, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}

object AddLogic extends App {

  val parser = new ExprParser
  val testCode1 =
    """
      |if (1==2) {2} else {3}
      |
    """.stripMargin

  println(parser(testCode1))

}
