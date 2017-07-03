package chapter15.task3

import com.sun.istack.internal.NotNull

import scala.annotation.meta._
import scala.beans.BeanProperty

/**
  * Упражнение 3 из главы 15
  */
class MetaAnnotation(@param @NotNull val field: String)

class MetaAnnotation2(@field @NotNull val field: String)

class MetaAnnotation3(@getter @setter @NotNull val field: String)

class MetaAnnotation4(@beanGetter @beanSetter @NotNull @BeanProperty val field: String)
