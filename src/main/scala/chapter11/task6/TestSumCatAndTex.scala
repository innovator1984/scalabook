package chapter11.task6

/**
  * Упражнение 6 из главы 11
  */
object TestSumCatAndTex extends App {

  val cat = new Figure(
    """ /\_/\ """,
    """( . . )""",
    """(  -  )""",
    """ | | | """,
    """(__|__)"""
  )

  val text = new Figure(
    """   -----  """,
    """ / Hello \""",
    """<  Scala |""",
    """ \ Coder /""",
    """  ------  """
  )

  println(cat + text)

}
