package scalaexercises

import org.scalatest.FunSuite

class ScalaExercises extends FunSuite{

  test("Pruebas sobre clases"){
    class Jugador(val nombre:String, val dorsal:Int)
    val Messi = new Jugador("Leonel", 10)
    assert(Messi.nombre.equals("Leonel"))
  }

  test("Pruebas sobre option"){
    val someValue: Option[String] = Some("Hello")
    val noneValue: Option[Int] = None
    assert(someValue.getOrElse("prueba").equals("Hello"))
    assert(noneValue.getOrElse("prueba").equals("prueba"))

    val sValue: Option[Double] = Some(20.0)
    val value = sValue match {
      case Some(v) ⇒ v
      case None ⇒ 0.0
    }
    assert(value.equals(20.0))

    val noValue: Option[Double] = None
    val value1 = noValue match {
      case Some(v) ⇒ v
      case None ⇒ 0.0
    }
    assert(value1.equals(0.0))

  }
}
