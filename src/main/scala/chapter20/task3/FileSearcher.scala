package chapter20.task3

import java.io.File

import akka.actor.{Actor, ActorRef}

/**
  * Упражнение 3 из главы 20
  */
class FileSearcher(manager: ActorRef) extends Actor with Worker {

  override val master: ActorRef = manager
  private var files = List.empty[File]

  override def receive: Receive = {

    case dir: File =>
      files = getAllFiles(dir).toList
      master ! ("getScanners", files.length)

    case Seq(scanners@_*) if scanners.nonEmpty && scanners.head.isInstanceOf[ActorRef] =>
      for (i <- files.indices)
        scanners(i).asInstanceOf[ActorRef] ! files(i)

  }

  def getAllFiles(dir: File): Iterator[File] = {
    val content = dir.listFiles()
    content.filter(_.isFile).toIterator ++ content.filter(_.isDirectory).flatMap(getAllFiles)
  }

}
