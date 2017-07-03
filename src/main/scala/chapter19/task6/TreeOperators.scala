package chapter19.task6

import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 6 из главы 19
  */
class Expr

case class Number(value: Int) extends Expr

case class Operator(op: String, left: Expr, right: Expr) extends Expr

class ExprParser extends RegexParsers {

  def wholeNumber: Parser[Int] = """[0-9]+(\.[0-9]+)?""".r ^^ (_.toInt)

  def factor: Parser[Expr] = wholeNumber ^^ (n => Number(n)) | "(" ~> expr <~ ")"

  def term: Parser[Expr] = (factor ~ opt("*" ~> term)) ^^ {
    case a ~ None => a
    case a ~ Some(b) => Operator("*", a, b)
  }

  def expr: Parser[Expr] = (term ~ rep(("+" | "-") ~ term)) ^^ {
    case a ~ list => (a /: list) {
      case (n, op ~ b) => Operator(op, n, b)
    }
  }

  def apply(input: String): Any = parseAll(expr, input) match {
    case Success(result, _) => result
    case err: NoSuccess => scala.sys.error(err.msg)
  }

}

object TreeOperators extends App {

  val parser = new ExprParser
  val test = "3-4-5"

  println(parser(test))

}
