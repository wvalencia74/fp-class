package classexercises

import org.scalatest.FunSuite

class Class2 extends FunSuite{

  test("factorial"){

  }

  test("Simular While"){

  }

  test("Evaluar if-elseif-else"){

  }

  test("imprimir valor del factorial - composicion de funciones"){

    case class A(a:Int, b:Int)

    val aa = A(1,2)

    aa match {
      case A(a,b) => A(a+1, b+1)
    }

  }


}
