package chapter18.task3

/**
  * Упражнение 3 из главы 18
  */
object Title

object Author

trait Document {

  var title: String
  var author: String

}

class Book extends Document{

  private var nextAttribute: Any = _
  override var title: String = _
  override var author: String = _

  def set(obj: Any): Book.this.type = {
    nextAttribute = obj
    this
  }

  def to(value: String): Book.this.type = {
    nextAttribute match {
      case Title => title = value
      case Author => author =value
    }
    this
  }

  override def toString: String = s"""This is book "$title" by $author """
}

object FreedomDocument extends App {

  val book = new Book

  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"

  println(book)
}
