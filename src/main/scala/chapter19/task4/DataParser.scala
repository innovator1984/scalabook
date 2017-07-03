package chapter19.task4

import scala.util.parsing.combinator.RegexParsers
import java.util.{Date, Calendar}

/**
  * Упражнение 4 из главы 19
  */
class DataParser extends RegexParsers {

  // ISO-8601 YYYY-MM-DDThh:mm (2017-05-30T15:46:10)

  private val fourNumbers = "[0-9]{4}".r ^^ (_.toInt)
  private val twoNumbers = "[0-9]{2}".r ^^ (_.toInt)
  private val calendar = Calendar.getInstance()

  def dateExpr: Parser[Date] =

    fourNumbers ~ "-" ~
      twoNumbers ~ "-" ~
      twoNumbers ~ "T" ~
      twoNumbers ~ ":" ~
      twoNumbers ~ ":" ~
      twoNumbers ^^ {
      case year ~ "-" ~ month ~ "-" ~ day ~ "T" ~ hour ~ ":" ~ min ~ ":" ~ sec =>
        calendar.set(year, month - 1, day, hour, min, sec)
        calendar.getTime

    }

  def parse(data: String): Date = parseAll(dateExpr, data) match {
    case Success(date, _) => date
    case err: NoSuccess => scala.sys.error(err.msg)
  }

}

object TestDataParser extends App {

  val parser = new DataParser

  println(parser.parse("2017-05-30T15:46:10"))

}
