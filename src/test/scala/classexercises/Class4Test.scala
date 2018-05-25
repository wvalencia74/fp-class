package classexercises

import classexercises.class4.Listas
import org.scalatest.{AsyncWordSpec, Matchers}


class Class4Test extends AsyncWordSpec with Matchers {

  val list = List(1, 2, 3)
  val list2 = List(1, 2, 3, 4)
  val list3 = List(1)

  "Con algunas operaciones sobre listas" should {

    "obtener el promedio de una lista " in {
      Listas.obtenerPromedio(list) shouldBe 2
      Listas.obtenerPromedio(list2) shouldBe 2.5
    }

    "sumar (+1) a cada elemento de la lista" in {
      Listas.addOne(list3).head shouldBe 2
      Listas.addOne(list).tail shouldBe List(3,4)
      Listas.addOne(list).head shouldBe 2
    }

    "sumar (+1) recursivo" in {
      Listas.addR(list) shouldBe List(2,3,4)
    }
  }

}

