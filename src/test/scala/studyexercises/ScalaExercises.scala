package studyexercises

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
    val value: Double = sValue match {
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

    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.fold(1)(_ * 3)
    val result2 = noNumber.fold(1)(_ * 3)

    assert(result1.equals(9))
    assert(result2.equals(1))
  }

  test("Pruebas sobre objects"){
    
  }

  test("Pruebas con tuplas"){
    val tuple4 = ("a", 1, 2.2, "five")

    assert(tuple4._1.equals("a"))

    val student = ("Maria", 21, 3.5)
    val (name, age, gpa) = student

    assert(name.equals("Maria"))
  }


  test("fold"){
    val inputList: List[Int] = List(1, 3, 5)

    def average(list: List[Double]): Double = list match {
      case head :: tail => tail.foldLeft((head, 1.0)) { (avg, cur) =>
        ((avg._1 * avg._2 + cur)/(avg._2 + 1.0), avg._2 + 1.0)
      }._1
      case Nil => 0.0
    }

    val opt1: Option[Int] = Some(5)
    opt1.fold(0)(_ + 1)
  }
}
