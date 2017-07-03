package chapter9.task5

import java.io.PrintWriter

/**
  * Упражнение 5 из главы 9
  */
object CreateTable extends App{

  import scala.math._

  val writer = new PrintWriter("src/main/resource/table.txt")
  (0 to 20).toArray.map(i => (pow(2,i), 1/pow(2,i))).map(x => x._1 +"\t"+ x._2).foreach(writer.println)
  writer.close()

}
