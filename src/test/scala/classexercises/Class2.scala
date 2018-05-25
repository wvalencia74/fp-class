package classexercises

import org.scalatest.FunSpec
import classexercises.class2._

class Class2 extends FunSpec {

  describe("El calculo de un factorial simple") {
    it("factorial") {
      assert(true, Factorial.calcularFactorial(4).equals(6))
    }
  }

  describe("Un factorial recursivo debe soportar números muy grandes") {
    it("factorial recursivo") {
      assert(true, Factorial.factorial(1557).isValidInt)
    }
  }

  describe("Hay dos maneras de realizar la composición de funciones - andThen - compose") {
    it("Composición de funciones") {
      assert(true, ComposicionFunciones.compose.equals(ComposicionFunciones.compose2))
    }
  }

}