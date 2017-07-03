package chapter18.task6

import scala.annotation.tailrec

/**
  * Упражнение 6 из главы 18
  */

object TestEither extends App {

  def getIndexWithValue(arr: Array[Int], value: Int): Int Either Int = {

    import scala.math.{abs,max}

    def toPreviousIndex(i: Int) = max(0, i - 1)

    def minDiffPredict(value: Int, indexValue: Int, previousIndexValue: Int): Boolean =
      abs(indexValue - value) < abs(previousIndexValue - value)

    @tailrec
    def findIndex(arrTail: Array[Int], numberOfIteration: Int): Int Either Int = {

      if (arrTail.isEmpty) Left(toPreviousIndex(numberOfIteration))
      else if (arrTail.head == value) Right(numberOfIteration)
      else if (arrTail.head > value) Left(
        if (minDiffPredict(value, arrTail.head, arr(toPreviousIndex(numberOfIteration)))) numberOfIteration
        else toPreviousIndex(numberOfIteration)
      )
      else findIndex(arrTail.tail, numberOfIteration + 1)
    }

    findIndex(arr, 0)

  }

  val arr = Array(1, 2, 3, 4, 7, 8, 9)
  val testValue = 6

  getIndexWithValue(arr, testValue) match {
    case Right(index) => println(s"Значению $testValue соответствует издекс $index")
    case Left(index) => println(s"Индекс ближайшего значения к $testValue равен $index")
  }


}
