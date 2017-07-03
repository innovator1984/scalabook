package chapter15.task9

/**
  * Упражнение 9 из главы 15
  */
class SimpleRange(val seq: Seq[Int]) {

  /*
  * Анотация @specialized(Unit) говорит компилятору что необходимо
  * добавить перегруженную копию метода foreach, в котором U: Unit
  * */
  def foreach[@specialized(Unit) U](f: Int => U) {
    seq.foreach(f)
  }

}

object SimpleRange {
  def apply(seq: Int*): SimpleRange = new SimpleRange(seq)
}

object TestSampleRange extends App {
  SimpleRange(1,2,3,4,5,6,7,8,9).foreach(println)
}

