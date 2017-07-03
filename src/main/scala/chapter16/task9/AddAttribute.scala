package chapter16.task9

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
  * Упражнение 9 из главы 16
  */
object AddAttribute extends App {

  val xHtml = XML.loadFile("src/main/resource/xHtmlExample.xhtml")

  println("--------- before ----------")
  xHtml \\ "img" foreach println

  val ruleImgAddAlt = new RewriteRule {
    override def transform(n: Node): Seq[Node] = n match {
      case elem @ <img/> if elem.attribute("alt").getOrElse("") == "" =>
        elem.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case other @ _ => other
    }
  }

  val newXHtml = new RuleTransformer(ruleImgAddAlt).transform(xHtml)

  println("--------- after ----------")
  newXHtml \\ "img" foreach println

}