package chapter14.task1

import java.io.File

import scala.io.Source

/**
  * Упражнение 1 из главы 14
  */
object SearchCaseIntoJDK extends App {

  // TODO Нужно указать путь к каталогу src JDK (после распаковки)
  val pathToSrcJDK = new File("/C:/tmp/src")

  val casePattern = """^.*(case)[^:]+:.*$""".r
  val caseWithFallPattern = """^\s*//.*alls?\s*(thr).*$""".r

  val statistic = getPathsToAllJavaFiles(pathToSrcJDK).view
    .flatMap(Source.fromFile(_, "UTF-8").getLines())
    .collect {
      case casePattern(_) => "case"
      case caseWithFallPattern(_) => "fall"
    }
    .groupBy(k => k)
    .map(kv => (kv._1, kv._2.size))

  // Вывод статистики
  println("Колличество блоков case в исходниках JDK: " + statistic("case"))
  println("Колличество блоков case с провалтванием в исходниках JDK: " + statistic("fall") +
    " (" + statistic("fall") * 100 / statistic("case") + "%)")

  // Получение путей для всех файлов с разрешением .java в квазанном каталоге и всех подкаталогах
  def getPathsToAllJavaFiles(dirPath: File): Seq[File] = {
    val files = dirPath.listFiles().filterNot(_.isDirectory).filter(_.toString.contains(".java"))
    val dirs = dirPath.listFiles().filter(_.isDirectory)
    files.toSeq ++ dirs.flatMap(getPathsToAllJavaFiles).toSeq
  }

}
