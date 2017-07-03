package chapter18.task10

/**
  * Упражнение 10 из главы 18
  */
object SelfType extends App {

  trait Service1Component {
    val service1: Service1
    trait Service1 {
      def announce(): Unit
    }
  }

  trait Service1ComponentImpl extends Service1Component {
    override val service1: Service1 = new Service1Impl
    private class Service1Impl extends Service1 {
      override def announce(): Unit = println("hi from Service1!")
    }
  }

  trait Service2Component {
    val service2: Service2
    trait Service2
  }

  trait Service2ComponentImpl extends Service2Component {
    this: Service1Component =>
    override val service2: Service2 = new Service2Impl
    private class Service2Impl extends Service2 {
      service1.announce() // has service1 been initialized yet?
    }
  }


  trait TopComponent1
    extends Service1Component
      with Service2Component

  trait TopComponent2
    extends Service2Component
      with Service1Component

  //Works
  val a = new {} with TopComponent1 with Service1ComponentImpl with Service2ComponentImpl

  //Throw java.lang.NullPointerException
  val b = new {} with TopComponent2 with Service2ComponentImpl with Service1ComponentImpl


}
