package chapter16.task10

import java.io.File

import scala.xml._
import scala.xml.dtd.{DocType, PublicID}
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
  * Упражнение 10 из главы 16
  */
object FunTransformationXHtml {

  def transformXML(inputFileName: String, outputFileName: String): Unit = {

    import scala.xml.parsing.ConstructingParser

    val parser = ConstructingParser.fromFile(new File(inputFileName), preserveWS = true)
    val doc = parser.document()
    val root = doc.docElem
    val docType = DocType("html", PublicID(doc.dtd.externalID.publicId, doc.dtd.externalID.systemId), Nil)

    val ruleImgAddAlt = new RewriteRule {
      override def transform(n: Node): Seq[Node] = n match {
        case elem @ <img/> if elem.attribute("alt").getOrElse("") == "" =>
          elem.asInstanceOf[Elem] % Attribute(null,"alt","TODO", Null)
        case other @ _ => other
      }
    }

    val result = new RuleTransformer(ruleImgAddAlt).transform(root).asInstanceOf[Node]

    XML.save(outputFileName, result, enc = "UTF-8", xmlDecl = false, docType)


  }


}

object TestFunTransformationXHtml extends App {

  import FunTransformationXHtml._

  transformXML("src/main/resource/xHtmlExampleDTD.xhtml","src/main/resource/xHtmlExampleDTD_transform.xhtml")

}
