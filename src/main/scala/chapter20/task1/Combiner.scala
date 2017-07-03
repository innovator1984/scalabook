package chapter20.task1

import akka.actor.Actor

/**
  * Упражнение 1 из главы 20
  */
class Combiner(val countReducers: Int) extends Actor {

  var cache: List[Double] = List.empty

  override def receive: Receive = {
    case (partAvg: Double, ts: Long) =>
      cache = partAvg :: cache
      if (cache.length >= countReducers) {
        println(cache.sum / countReducers)
        println(s"time of work: ${System.currentTimeMillis() - ts} millis.")
      }
  }

}
