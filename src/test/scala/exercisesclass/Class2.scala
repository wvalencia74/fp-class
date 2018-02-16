package exercisesclass

import org.scalatest.FunSuite

class Class2 extends FunSuite{

  test("factorial"){

  }

  test("Simular While"){
    def simularWhile(condition:Boolean): Unit ={
      if(condition) simularWhile(true)
      else simularWhile(false)
    }
  }

  test("Evaluar if-elseif-else"){
    def probarIfElse(firstCondition:Boolean, secondCondition:Boolean, one:Any, two:Any, three:Any) ={
      if(firstCondition) one
      else if (secondCondition) two
      else three
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

    /*def dividir [A <: Double](dividendo:A, divisor:A) = {
      if(!divisor.eq(0)) dividendo/divisor
    }

    def div:Double => Double => Double = x => y match y {
      case y != 0 => x/y
    }*/

  }


}
