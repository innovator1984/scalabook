package chapter10.task8

import java.io.FileInputStream

/**
  * Упражнение 8 из главы 10
  */
object AbbBufferToIS extends App {

  val is = new FileInputStream("src/main/resource/forIs.txt") with Buffer

  var byteCount: Int = 0
  var buffer: Array[Byte] = new Array[Byte](1024)

  while(byteCount != -1) {
    byteCount = is.read()
    print(if (byteCount != -1) byteCount.toChar)
  }

}
