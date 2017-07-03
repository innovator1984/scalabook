package chapter19.task3

import scala.util.parsing.combinator.RegexParsers

/**
  * Упражнение 3 из главы 19
  */
class IntParser extends RegexParsers {

  def intNumber: Parser[Int] = "[-0-9]+".r ^^ (_.toInt)

  def expr: Parser[List[Int]] = opt("(") ~> repsep(intNumber, ",") <~ opt(")")

  def apply(input: String): List[Int] = parseAll(expr, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}

object TestIntParser extends App {

  val parser = new IntParser

  println(parser("(1, 23, -79"))

}
