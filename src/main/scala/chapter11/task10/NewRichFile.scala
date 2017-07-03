package chapter11.task10

/**
  * Упражнение 10 из главы 11
  */
class NewRichFile (val path: String)
object NewRichFile {
  def unapplySeq(arg: NewRichFile): Option[Seq[String]] =
  if (arg.path.length == 0) None else
    Some(arg.path.split("/").filter(_.length > 0 ).toSeq)
}

object TestNewRichFile extends App {

  val file = new NewRichFile("/home/coder/Test.scala")
  file match {
    case NewRichFile(d1,d2) => println(d1,d2)
    case NewRichFile(d1,"",d3) => println((d1,d3))
    case NewRichFile(d1,"coder","",d3) => println((d1,d3))
    case NewRichFile(d @ _*) => println(d)

  }
}
