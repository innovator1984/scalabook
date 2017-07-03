package chapter20.task2

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import akka.actor.Actor

/**
  * Упражнение 2 из главы 20
  */
class ImageRowCombiner(val img: BufferedImage, val invertFile: File) extends Actor {

  private val countRows = img.getHeight
  private var countReplacedRows = 0

  override def receive: Receive = {
    case (row: Int, colors: Array[Color]) =>
      replaceRowColor(row, colors)
      countReplacedRows += 1
      if (countRows == countReplacedRows)
        ImageIO.write(img, "jpg", invertFile)
  }

  def replaceRowColor(row: Int, colors: Array[Color]): Unit =
    if (colors.length == 1)
      img.setRGB(colors.length - 1, row, colors(0).getRGB)
    else {
      img.setRGB(colors.length - 1, row, colors(0).getRGB)
      replaceRowColor(row, colors.drop(1))
    }

}
