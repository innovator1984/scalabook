package chapter10.task1

/**
  * Упражнение 1 из главы 10
  */
trait RectangleLike {

  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def setFrame(x:Double, y:Double, width: Double, height: Double): Unit

  def grow(dx: Double, dy: Double): Unit = setFrame(getX - dx, getY - dy, getWidth + dx * 2, getHeight + dy * 2)
  def translate(dx: Double, dy: Double): Unit = setFrame(getX + dx, getY + dy, getWidth, getHeight)

  override def toString: String = this.getClass.getName + "[x=" + getX + ",y=" + getY + ",width=" + getWidth + ",height=" + getHeight + "]"


}
