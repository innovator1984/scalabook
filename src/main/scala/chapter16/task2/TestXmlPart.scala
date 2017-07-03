package chapter16.task2

/**
  * Упражнение 2 из главы 16
  */
object TestXmlPart extends App {

  /*
  * Одинарными фигурными скобками обозначается вставка scala кода в xml.
  * Если нужно вставить фигурную скобку, нужно использвать двойную скобку {{ или }}
  * Иначе код не скомпилируется.
  * */
  val element =
    <ul>
      <li>Opening bracket: [</li>
      <li>Closing bracket: ]</li>
      <li>Opening brace: {{ </li>
      <li>Closing brace: }}</li>
    </ul>

  println(element)

}
