package chapter20.task2

import java.awt.Color

import akka.actor.{Actor, ActorRef}

/**
  * Упражнение 2 из главы 20
  */
class RowColorInverter(val combiner: ActorRef) extends Actor {

  private val white = 255

  override def receive: Receive = {

    case (row: Int, pixels: Array[Int]) =>

      val colors = pixels.map(new Color(_, true))
        .map(color => new Color(
          white - color.getRed,
          white - color.getGreen,
          white - color.getBlue
        ))

      combiner ! (row, colors)

  }

}
