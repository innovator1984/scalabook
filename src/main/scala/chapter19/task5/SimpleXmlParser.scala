package chapter19.task5

import scala.util.parsing.combinator.RegexParsers
import scala.xml.{Attribute, Null, Elem => xElem}

/**
  * Упражнение 5 из главы 19
  */
class SimpleXmlParser extends RegexParsers {

  def tagName: Parser[String] = """[a-zA-Z]+""".r

  def text: Parser[String] = """[^<]*""".r

  def attrName: Parser[String] = tagName <~ "="

  def attrValue: Parser[String] = ("'" | "\"") ~> """[a-zA-Z0-9]*""".r <~ ("'" | "\"") ^^ (_.toString())

  def attr: Parser[(String, String)] = attrName ~ attrValue ^^ (attr => (attr._1, attr._2))

  def openTag: Parser[(String, List[Attribute], Boolean)] = "<" ~> tagName ~ rep(attr) ~ (">" | "/>") ^^ {
    case name ~ attr ~ min => (name, attr.map(attr => Attribute(null, attr._1, attr._2, Null)), min == "/>")
  }

  def closeTag: Parser[String] = "</" ~> tagName <~ ">"

  def xmlElem: Parser[List[xElem]] = rep(openTag ~ text ~ closeTag) ^^ {
    _.collect {
      case openTag ~ text ~ closeTag if openTag._1 == "ident" && openTag._1 == closeTag =>
        (<root>{text}</root>.copy(label = openTag._1) /: openTag._2) ((n, a) => n % a)
    }
  }

  def apply(input: String): List[xElem] = parseAll(xmlElem, input) match {
    case Success(elem, _) => elem
    case err: NoSuccess => scala.sys.error(err.msg)
  }


}

object TestSimpleXmlParser extends App {

  val parser = new SimpleXmlParser

  val testXml =
    """
      |<ident key="1" value="100">text value</ident>
      |<other>text value</other>
      |<ident>text value</ident>
    """.stripMargin

  parser(testXml) foreach println

}

