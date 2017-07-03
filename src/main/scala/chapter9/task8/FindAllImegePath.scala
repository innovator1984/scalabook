package chapter9.task8

import scala.io.Source

/**
  * Упражнение 8 из главы 9
  */
object FindAllImegePath extends App {

  val imgPattern = """<img.+src="([^"]+)".+>""".r
  for (imgPattern(path) <-imgPattern.findAllIn(Source.fromFile("src/main/resource/stackoverflow.html","UTF-8").mkString)) println(path)


}
