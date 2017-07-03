package chapter15.task5

import java.io.{FileNotFoundException, InputStream}

import scala.io.Source

/**
  * Упражнение 5 из главы 15
  */
class FromFile {

  @throws(classOf[FileNotFoundException]) def readFile(is: InputStream): String =
    Source.fromInputStream(is).getLines().mkString

}
