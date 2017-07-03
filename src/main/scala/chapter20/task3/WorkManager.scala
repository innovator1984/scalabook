package chapter20.task3

import java.io.File

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.mutable.{Map => mMap}

/**
  * Упражнение 3 из главы 20
  */
class WorkManager(val system: ActorSystem) extends Actor {

  private val scannerStatuses = mMap.empty[ActorRef, String]

  val searcher: ActorRef = system.actorOf(Props(new FileSearcher(self)), "searcher")

  override def receive: Receive = {

    case dir: File => system.actorSelection("/user/searcher") ! dir

    case ("getScanners", count: Int) =>

      val combiner = system.actorOf(Props(new Combiner(self)), "combiner")
      val scanners: Seq[ActorRef] = for (i <- 0 until count) yield
        system.actorOf(Props(new FileScanner(self, combiner,"""the""".r)), s"scanner$i")
      scanners.foreach(scanner => scannerStatuses += (scanner -> "running"))
      system.actorSelection("/user/searcher") ! scanners

    case ("scannerSuccess", scanner: ActorRef) =>
      system.stop(scanner)
      scannerStatuses(scanner) = "ok"
      if (scannerStatuses.count(s => s._2 == "running") == 0) system.actorSelection("/user/combiner") ! "result"

    case "finish" =>
      system.terminate()
  }

}
