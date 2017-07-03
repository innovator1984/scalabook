package chapter18.task2

/**
  * Упражнение 2 из главы 18
  */
object show

object `then`

object around

trait Bug {

  def move(path: Int): this.type

  def and(act: show.type): this.type

  def and(act: `then`.type): this.type

  def turn(act: around.type): this.type

}

class SimpleBug extends Bug {

  private var currentPosition = 0
  private var trend = true

  override def move(path: Int): SimpleBug.this.type = {
    if (trend) currentPosition += path else currentPosition -= path
    this
  }

  override def and(act: show.type): SimpleBug.this.type = {
    print(s"$currentPosition ")
    this
  }

  override def and(act: `then`.type): SimpleBug.this.type = this

  override def turn(act: around.type): SimpleBug.this.type = {
    trend = !trend
    this
  }
}

object FreedomBug extends App {

  val bugsy = new SimpleBug

  bugsy move 4 and show and `then` move 6 and show turn around move 5 and show

}
