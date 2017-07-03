package chapter9.task10

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

/**
  * Упражнение 10 из главы 9
  */
@SerialVersionUID(109) class Person(val name: String, val age: Int) extends Serializable {
  import scala.collection.mutable.ArrayBuffer

  val friends = new ArrayBuffer[Person]

  override def toString: String = (name,age).toString() + friends.map(p => (p.name, p.age)).mkString("{",",","}")
}

object SaveFriendsCollections extends App {

  val person = new Person("Alex",30)
  person.friends += new Person("Bob",31) += new Person("Mary",29)
  println("original: "+ person)

  val objWriter = new ObjectOutputStream(new FileOutputStream("src/main/resource/person.obj"))
  objWriter.writeObject(person)
  objWriter.flush()
  objWriter.close()

  val reader = new ObjectInputStream(new FileInputStream("src/main/resource/person.obj"))
  val savedPerson = reader.readObject()
  reader.close()

  println("saved: "+ savedPerson)

}