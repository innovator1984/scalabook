package chapter15.task8

/**
  * Упражнение 8 из главы 15
  */
class AnnotationSpecialized {

  /*
  * В байткоде добавлены перегруженные реализации метода для приметивных типов
  * */
  def allDifferent[@specialized T](x: T, y: T): Boolean = x != y

}
