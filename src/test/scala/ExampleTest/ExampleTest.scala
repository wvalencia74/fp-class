package ExampleTest
import org.scalatest.FunSuite

/**
  * Created by william on 9/02/18.
  */

class ExampleTest extends FunSuite {

  test("Define a simple val") {

    val home = "home" + 2

    assert(home.size.equals(5))
    assert(home.equalsIgnoreCase("home2"));
  }

  test("factorial"){
    def simularWhile[A](valorMientras:Boolean ):Any = {
      if(valorMientras) {
        print(5*5)
        simularWhile(true)
      }
    }
  }

  test("evaluar if-else"){

    def ifELse(a:Boolean, x:Boolean, hh:Any, ba:Any, ab:Any) = {
      if(a) ba else if (x) ab else hh
    }
  }

  test("imprimir valor del factorial"){

    def calcularFacturial(a:Int): Int = ???

    def imprimirValor(factorial:Int) ={
      s"El factorial del número es: $factorial"
    }

    //Composición de funciones
    val x = (calcularFacturial _ andThen imprimirValor )(3)

    val y = (imprimirValor _ compose calcularFacturial _ )(3)

    def foo(a:Int, b:Int) = ???

    def hof[A,  B](x: A, msg: String, f: A => B) = {
      s"el $msg es : ${f(x)}"
    }

    def dividir [A <: Double](dividendo:A, divisor:A) = {
      if(!divisor.eq(0)) dividendo/divisor
    }

    def div:Double => Double => Double = x => y match y {
      case y != 0 => x/y
    }

  }

  test("uso of and then"){

  }

  test("Test functions") {

    def writePretty(a:Int) = "Esto es un: " + a

    def ordenizePreviewPrint(x:String, a:Int): String = writePretty(a) + x

    def findArea(l:Double) = l*4
    val areaOfFour = findArea(4)

    assert(!writePretty(3).isEmpty)
    assert(ordenizePreviewPrint(" gracias!", 3).equalsIgnoreCase("Esto es un: 3 gracias!"))
    assert(areaOfFour.equals(16.0))

  }

}
