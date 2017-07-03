package chapter9.task9

/**
  * Упражнение 9 из главы 9
  */
object FindFiles extends App {

  import java.io.File

  val workDir = new File("target")

  def find(dir: File): Iterator[File] = {
    val files = dir.listFiles().filter(_.isDirectory)
    files.toIterator ++ files.flatMap(find)
  }

  print(find(workDir).flatMap(_.listFiles()).map(_.toString).count(_.contains(".class")))

}
