package chapter10.task7

/**
  * Упражнение 7 из главы 10
  */
trait NumberPrinter extends Printer {

  abstract override def print(obj: Any): Unit = obj match {
      case o:Int => super.print(o.toInt + " -> Int")
      case o:Short => super.print(o.toShort + " -> Short")
      case o:Byte => super.print(o.toByte + " -> Byte")
      case o:Double => super.print(o.toDouble + " -> Double")
      case o:Float => super.print(o.toFloat + " -> Float")
      case _ => super.print("It is not Number")
    }

}
