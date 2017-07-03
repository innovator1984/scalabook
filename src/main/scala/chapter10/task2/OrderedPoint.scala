package chapter10.task2

import java.awt.Point
import scala.math.Ordered

/**
  * Упражнение 2 из главы 10
  */
trait OrderedPoint extends Ordered[Point] {

  def getX: Double
  def getY: Double

  def compare(that: Point): Int = if (this.getX < that.getX || (this.getX == that.getX && this.getY < that.getY)) -1
    else if(this.getX == that.getX && this.getY == that.getY) 0 else 1

}
