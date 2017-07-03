package chapter20.task3

import java.io.File

import akka.actor.{ActorSystem, Props}

/**
  * Упражнение 3 из главы 20
  */
object Task3Run extends App {

  val system = ActorSystem("task3")

  val master = system.actorOf(Props(new WorkManager(system)))

  master ! new File("d:/tmp")

}
