package chapter18.task1

/**
  * Упражнение 1 из главы 18
  */
trait Bug {

  def move(path: Int): this.type

  def turn(): this.type

  def show(): this.type
}

class SimpleBug extends Bug {

  private var currentPosition = 0
  private var trend = true

  override def move(path: Int): SimpleBug.this.type = {
    if (trend) currentPosition += path else currentPosition -= path
    this
  }

  override def turn(): SimpleBug.this.type = {
    trend = !trend
    this
  }

  override def show(): SimpleBug.this.type = {
    print(s"$currentPosition ")
    this
  }

}

object BugMoving extends App {

  val bugsy = new SimpleBug

  bugsy.move(4).show().move(6).show().turn().move(5).show()

}
