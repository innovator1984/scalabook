package chapter15.task2

/**
  * Упражнение 2 из главы 15
  */
@deprecated
class AnnotationPosition(@deprecated val depField: String) {

  @deprecated def depMethod(arg: String): String = arg

  def methodDepArg(@deprecated arg: String): String = arg

  def methodDepType(arg: String@deprecated): String = {

    @deprecated val result = arg

    val test = (arg.toUpperCase(): @unchecked) == "qqq"

    result concat test.toString

  }

}
