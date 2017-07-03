package chapter16.task3

import scala.xml.{Elem, Text}

/**
  * Упражнение 3 из главы 16
  */
object MatchingXmlParts extends App {

  val t1 = <li>Fred</li> match {
    case <li>{Text(t)}</li> => t
    case _: Elem => "t is Elem"
  }

  val t2 = <li>{"Fred"}</li> match {
    case <li>{Text(t)}</li> => t
    case _: Elem => "t is Elem"
  }

  /*
  * В первом случае (t1) выводится Fred, так как это Text
  * Во втором случае (t2) выводится t is Elem, так как это Atom
  * */
  println(t1)
  println(t2)

}
