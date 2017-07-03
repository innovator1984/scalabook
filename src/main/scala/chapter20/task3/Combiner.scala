package chapter20.task3

import akka.actor.{Actor, ActorRef}

/**
  * Упражнение 3 из главы 20
  */
class Combiner(manager: ActorRef) extends Actor with Worker {

  var acc = 0

  override val master: ActorRef = manager

  override def receive: Receive = {

    case n: Int => acc += n

    case "result" =>
      println(acc)
      master ! "finish"

  }

}
