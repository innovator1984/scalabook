package chapter11.task9

/**
  * Упражнение 9 из главы 11
  */
class RichFile (val path: String)
object RichFile {
  def unapply(arg: RichFile): Option[(String,String,String)] = {
    val arr = arg.path.split("/")
    val fullFileName = arr(arr.length-1)
    val fileName = fullFileName.split("""\.""")
    val onlyPath = new Array[String](arr.length-1)
    Array.copy(arr,0,onlyPath,0,arr.length-1)
    Some(onlyPath.mkString("/"),fileName(0),fileName(1))
  }
}

object TestRichFile extends App {

  val fullPathToFile = new RichFile("/home/coder/Test.scala")
  val RichFile(a,b,c) = fullPathToFile
  println(a)
  println(b)
  println(c)


}
