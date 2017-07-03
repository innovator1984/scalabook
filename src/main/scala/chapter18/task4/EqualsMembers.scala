package chapter18.task4

import scala.collection.mutable.ArrayBuffer

/**
  * Упражнение 4 из главы 18
  */
class Network {

  class Member(val name: String) {

    val contacts = new ArrayBuffer[Member]()

    override def equals(obj: scala.Any): Boolean = obj match {
      case _: Member => true
      case _ => false
    }

  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val member = new Member(name)
    this.members += member
    member
  }

}

object EqualsMembers extends App {

  val office = new Network
  val home = new Network

  val alex = office.join("Alex")
  val jon = office.join("Jon")
  val serge = home.join("Serge")

  println(alex.equals(jon))
  println(alex.equals(serge))
}
