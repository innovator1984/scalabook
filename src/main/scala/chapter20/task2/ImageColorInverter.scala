package chapter20.task2

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import akka.actor.{ActorSystem, Props}

/**
  * Упражнение 2 из главы 20
  */
object ImageColorInverter extends App {

  val originalFile = "src/main/resource/2_20.jpg"
  val invertFile = "src/main/resource/inv_2_20.jpg"

  val img = ImageIO.read(new File(originalFile))

  val system = ActorSystem("ImageColorInverter")
  val combiner = system.actorOf(Props(classOf[ImageRowCombiner], img, new File(invertFile)))
  val rowInverter1 = system.actorOf(Props(classOf[RowColorInverter], combiner))
  val rowInverter2 = system.actorOf(Props(classOf[RowColorInverter], combiner))

  for (row <- 0 until img.getHeight)
    if (row % 2 == 0)
      rowInverter1 ! (row, createPixelsArr(row, img))
    else
      rowInverter2 ! (row, createPixelsArr(row, img))

  def createPixelsArr(row: Int, img: BufferedImage): Array[Int] = {
    for (i <- 0 until img.getWidth) yield img.getRGB(i, row)
  }.toArray.reverse

}
