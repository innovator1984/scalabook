package chapter10.task8

import java.io.{InputStream,BufferedInputStream}

/**
  * Упражнение 8 из главы 10
  */
trait Buffer extends InputStream {

  override def read(): Int = {
    val buffIs = new BufferedInputStream(this,1)
    buffIs.read()
  }


}
