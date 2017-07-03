package chapter18.task7

import scala.language.reflectiveCalls

/**
  * Упражнение 7 из главы 18
  */

class Resource {

  private var openStatus = true

  def close(): Unit = {
    openStatus = false
    println("Close resource")
  }

  def readArray(): Array[Int] = {

    import scala.math.random

    if (openStatus) (0 to (random() * 100).toInt).toArray
    else throw new Exception("Resource has been closed")

  }

}

object ProcessCloseObject extends App {

  def process(fun: ({def close(): Unit}) => Int, obj: {def close(): Unit}): Unit = try obj match {

    case resource: Resource => println(fun(resource))

  } catch {

    case e: Exception => println(e.getMessage)

  } finally obj.close()

  val resource = new Resource

  process(r => r.asInstanceOf[Resource].readArray().sum, resource)
  process(r => r.asInstanceOf[Resource].readArray().sum, resource)


}
