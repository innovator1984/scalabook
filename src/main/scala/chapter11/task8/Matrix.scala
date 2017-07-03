package chapter11.task8

/**
  * Упражнение 8 из главы 11
  */
class Matrix(n: Int) {
  val body = new Array[Array[Int]](n)
  for (i <- 0 until n) body(i) = new Array[Int](n)

  def update(xIndex: Int, yIndex: Int, value: Int) {
    body(yIndex-1)(xIndex-1) = value
  }

  def apply(xIndex: Int, yIndex: Int): Int = body(yIndex-1)(xIndex-1)

  override def toString: String = body
    .map(_.mkString("|", " ", "|"))
    .mkString("\n")

  def +(that: Matrix): Matrix = {
    val newMatrix = new Matrix(n)
    for (i <- 1 to n)
      for (j <- 1 to n)
        newMatrix(i,j) = this(i,j) + that(i,j)
    newMatrix
  }

  def *(const: Int): Matrix = {
    val newMatrix = new Matrix(n)
    for (i <- 1 to n)
      for (j <- 1 to n)
        newMatrix(i,j) = this(i,j) * const
    newMatrix
  }

  def *(that: Matrix): Matrix = {
    val newMatrix = new Matrix(n)
    for (i <- 1 to n)
      for (j <- 1 to n)
        for (k <- 1 to n) {
          newMatrix(i, j) = newMatrix(i, j) + this (i, k) * that(k, j)
        }
    newMatrix
  }
}

object TestMatrix extends App {
  val matrix1 = new Matrix(3)
  matrix1(1,1) = 2
  val matrix2 = new Matrix(3)
  matrix2(1,2) = 2

  val matrix3 = new Matrix(3)
  var value = 0
  for (i <- 1 to 3)
    for (j <- 1 to 3) {
      value += 1
      matrix3(j, i) = value
    }

  println(matrix1 + "\n")
  println(matrix2 + "\n")
  println(matrix3 + "\n")
  println((matrix1 + matrix2) + "\n")
  println((matrix1 + matrix2) * 2 + "\n")
  println((matrix3 * matrix3) + "\n")
}