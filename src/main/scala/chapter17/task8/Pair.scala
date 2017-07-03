package chapter17.task8

/**
  * Упражнение 8 из главы 17
  */
class Pair[T](var first: T, val second: T) {

  /*
  * В результате этого метода создаётся новый объект класс Pair[R],
  * где R - суперкласс для T, следовательно Т преобразуется к R без потерь.
  *
  * val x:Person = new Student("Mik", 35, 1)
  * val x:Person = new Person("Mik", 35)
  *
  * */
  def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)

  /*
  * Несмотря на то, что поле first объявлено как var метод не компилируется.
  * Этот метод не создаёт новый объект, а изменяет значения поля в существующем.
  * В существующем объекте поле first имеет тип T(Student - наследник),
  * а присваевается ему значение типа R(Person - суперкласс).
  * Соответственно компилятор этого сделать не может:
  *
  * val x:Student = new Person("Mik", 35) // ОШИБКА
  *
  * */
  //def replaceFirst[R >: T](newFirst: R) = {first=newFirst}

  override def toString: String = s"""Pair($first,$second)"""

}

class Person(val name: String, val age: Int) {
  override def toString: String = s"""Person($name,$age)"""
}

class Student(name: String, age: Int, val course: Int) extends Person(name, age) {
  override def toString: String = s"""Student($name,$age,$course)"""
}

object TestPair extends App {

  val student = new Student("Alex", 25, 3)
  val person = new Person("Mik", 35)


  val pair1 = new Pair[Student](student, student)
  val pair2 = pair1.replaceFirst(person)

  println(pair1)
  println(pair2)

  val x: Person = new Student("Mik", 35, 1)


}


