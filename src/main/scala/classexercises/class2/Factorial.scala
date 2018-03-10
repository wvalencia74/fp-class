package classexercises.class2

import scala.annotation.tailrec

object Factorial {

  def calcularFactorial(num:Int): Int = {
    if(num == 0) 1
    else num * calcularFactorial(num-1)
  }

  def factorial(num:Int):Int ={
    @tailrec
    def factLoop(n:Int, acc:Int):Int = {
      if(n<=1)acc else factLoop(n-1, n*acc)
    }
    factLoop(num,1)
  }

  def imprimirValor(factorial:Int) ={
    s"El factorial del número es: $factorial"
  }

  @tailrec
  def maxDiv(a:Int, b:Int, acc:Int, aux:Int): Int= {
    if(acc>a || acc>b) aux
    else if (a%acc==0 && b%acc==0) maxDiv(a, b, acc+1, acc)
    else maxDiv(a,b,acc+1,aux)
  }

  def fact0: PartialFunction[Int,Int] = { case 0 => 1}
  def factR: PartialFunction[Int,Int] = { case n => n*factR(n-1)}
  def factC: Int => Int = fact0 orElse(factR)

}
