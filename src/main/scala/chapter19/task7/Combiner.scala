package chapter19.task7

import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 7 из главы 19
  */

class ExprParser extends RegexParsers {

  def wholeNumber: Parser[Int] = """[0-9]+(\.[0-9]+)?""".r ^^ (_.toInt)

  def factor: Parser[Int] = wholeNumber | "(" ~> expr <~ ")"

  def term: Parser[Int] = (factor ~ opt("*" ~> term)) ^^ {
    case a ~ None => a
    case a ~ Some(b) => a * b
  }

  def expr: Parser[Int] = (term ~ rep(("+" | "-") ~ term)) ^^ {
    case a ~ list => (a /: list) {
      case (n, "-" ~ b) => n - b
      case (n, "+" ~ b) => n + b
    }
  }

  def apply(input: String): Any = parseAll(expr, input) match {
    case Success(result, _) => result
    case err: NoSuccess => scala.sys.error(err.msg)
  }

}

object Combiner extends App {

  val parser = new ExprParser
  val test = "3-4+5"

  println(s"3-4+5=${parser(test)}")

}
