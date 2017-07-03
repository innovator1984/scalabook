package chapter17.task4

/**
  * Упражнение 4 из главы 17
  */
class Pair[T](val first: T, val second: T) {

  /*
  * Определение верхней граници не требуется при замене компанента в Pair[Person] на Student,
  * потому что Student является наследниеом Person и кастуется в Person без потери данных
  * */
  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)

  override def toString: String = s"""Pair($first,$second)"""

}

class Person(val name: String, val age: Int) {
  override def toString: String = s"""Person($name,$age)"""
}

class Student(name: String, age: Int, val course: Int) extends Person(name, age) {
  override def toString: String = s"""Student($name,$age,$course)"""
}


object TestUpperBound extends App {

  val student1 = new Student("Alex", 25, 3)
  val person1 = new Person("Mik", 35)
  val person2 = new Person("Dan", 37)

  val pair1 = new Pair[Person](person1, person2)
  println(pair1)

  val pair2 = pair1.replaceFirst(student1)
  println(pair2)

}

