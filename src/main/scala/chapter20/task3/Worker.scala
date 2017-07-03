package chapter20.task3

import akka.actor.ActorRef

/**
  * Упражнение 3 из главы 20
  */
trait Worker {

  val master: ActorRef

}
