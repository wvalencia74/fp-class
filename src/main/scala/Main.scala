
import classexercises.class2.TestObject.testObj
import classexercises.class2._
import classexercises.class7._
import classexercises.class12._

object Main {
  def main(args: Array[String]): Unit = {
    //println("Hello, world!")
    //println(calcularFactorial(5))
    //println(maxDiv(96,135,1,1))
    //println(factC(0))
    //testObj
    //println(ComposicionFunciones.compose2("1"))
    //Futuros.futureSeq()
    //println(SimularGet.getUsuario())
    //println(Semigroups.combine())
  }

  def foo(a:Int=>Int) = a(3)

  val sumOne = (a:Int) => a +1

  foo(sumOne)

  def fooTwo(x:Int):Int=>Int = x => x*2
}
