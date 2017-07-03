package chapter18.task5

import scala.collection.mutable.ArrayBuffer

// После этого экспорта компиляция выполняется без ошибок, несмотря на предупреждения
import scala.language.existentials

/**
  * Упражнение 5 из главы 18
  */
class Network {

  class Member(val name: String) {

    val contact = new ArrayBuffer[Member]()

  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val member = new Member(name)
    this.members += member
    member
  }

}

object TestNetworkMember extends App {

  type NetworkMember = n.Member forSome {val n: Network}

  // из задания
  def process1(m1: NetworkMember, m2: NetworkMember): (NetworkMember, NetworkMember) = (m1, m2)

  // из текста
  def process2[M <: n.Member forSome {val n : Network}](m1: M, m2: M): (M, M) = (m1, m2)

  val office = new Network()
  val home = new Network()

  val alex = office.join("Alex")
  val jon = office.join("Jon")
  val serge = home.join("Serge")

  /*
  * В функцию process1 можно подставить члена любого сообщества
  * */
  println(process1(alex,serge)) // Ошибка

  /*
  * В метод process2 можно поставить только членов из одного сообщества
  * */
  process2(alex,jon)
  //process2(alex,serge) // Ошибка выполнения

}
