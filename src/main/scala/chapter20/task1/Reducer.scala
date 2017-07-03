package chapter20.task1

import akka.actor.{Actor, ActorRef}

/**
  * Упражнение 1 из главы 20
  */
class Reducer(val combiner: ActorRef) extends Actor {

  override def receive: Receive = {
    case (data: Array[Double], ts: Long) => combiner ! (data.sum / data.length, ts)
  }

}
