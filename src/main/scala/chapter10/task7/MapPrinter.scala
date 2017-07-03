package chapter10.task7

/**
  * Упражнение 7 из главы 10
  */
trait MapPrinter extends Printer {

  val begin = "{"
  val end = "}"
  val sep = ","

  abstract override def print(obj: Any): Unit = obj match {
    case m: Map[Any,Any] => super.print(m.map(kv => modificatilnKV(kv)).mkString(begin,sep,end))
    case _ => super.print("It is not Map[Any,Any]")
  }

  def modificatilnKV(kv: Tuple2[Any,Any]): String = {
    val key = if (kv._1.isInstanceOf[Number]) kv._1 else "\""+kv._1+"\""
    val value = if (kv._2.isInstanceOf[Number]) kv._2 else "\""+kv._2+"\""
    "" + key + ":" + value
  }

}
