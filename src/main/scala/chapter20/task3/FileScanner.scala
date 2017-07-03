package chapter20.task3

import java.io.File

import akka.actor.{Actor, ActorRef}

import scala.io.Source
import scala.util.matching.Regex

/**
  * Упражнение 3 из главы 20
  */
class FileScanner(manager: ActorRef, combiner: ActorRef, regexPattern: Regex) extends Actor with Worker {

  override val master: ActorRef = manager

  override def receive: Receive = {
    case file: File =>
      val count = Source.fromFile(file, "UTF-8")
        .getLines()
        .map(_.replaceAll("""\s+""", " ").toLowerCase)
        .flatMap(_.split("""\s"""))
        .count(regexPattern.findAllIn(_).nonEmpty)

      combiner ! count
      master ! ("scannerSuccess", self)

  }


}
