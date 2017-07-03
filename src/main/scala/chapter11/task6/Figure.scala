package chapter11.task6

/**
  * Упражнение 6 из главы 11
  */
trait SumFigure {def +(that: Figure): Figure}
class Figure(val body: String*) extends SumFigure {

  def +(that: Figure): Figure = new Figure((
    for (i <- 0 to this.body.length - 1) yield
      if (i <= that.body.length) this.body(i) + " " + that.body(i) else this.body(i)
    ): _*)


  override def toString: String = body.mkString("\n")
}
