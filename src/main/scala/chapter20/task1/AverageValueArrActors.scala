package chapter20.task1

import java.util.Arrays._

import akka.actor.{ActorSystem, Props}


/**
  * Упражнение 1 из главы 20
  */
object AverageValueArrActors extends App {

  val n = 99999999
  val testArray = new RandomIntArray(n).array

  val system = ActorSystem("task1_20")

  val combiner = system.actorOf(Props(classOf[Combiner], 3))

  val reducer1 = system.actorOf(Props(classOf[Reducer], combiner))
  val reducer2 = system.actorOf(Props(classOf[Reducer], combiner))
  val reducer3 = system.actorOf(Props(classOf[Reducer], combiner))

  val r1 = copyOfRange(testArray, 0, 33333333)
  val r2 = copyOfRange(testArray, 33333333, 66666666)
  val r3 = copyOfRange(testArray, 66666666, 99999999)

  val ts = System.currentTimeMillis()
  reducer1 ! (r1,ts)
  reducer2 ! (r2,ts)
  reducer3 ! (r3,ts)


}

