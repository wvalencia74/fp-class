import scala.annotation.tailrec

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    println(factorial(10))
  }

  def factorial(num:Int): Int ={
    if(num <= 1){
      num
    }
    else num * factorial(num-1)
  }

  def fact0: PartialFunction[Int,Int] = { case 0 => 1}
  def factR: PartialFunction[Int,Int] = { case n => n*factR(n-1)}
  def factC:Int => Int = fact0 orElse(factR)

  def fact(x:Int):Int ={
    @tailrec
    def factLoop(n:Int, acc:Int):Int = {
      if(n<=1)acc else factLoop(n-1, n*acc)
    }
    factLoop(x,1)
  }

  @tailrec
  def maxDiv(a:Int, b:Int, acc:Int, aux:Int): Int= {
    if(acc>a || acc>b) aux
    else if (a%acc==0 && b%acc==0) maxDiv(a, b, acc+1, acc)
    else maxDiv(a,b,acc+1,aux)
  }

  println(maxDiv(96,135,1,1))


  class Point(x: Int, y: Int) {

    override def toString(): String = "(" + x + ", " + y + ")"
  }

  class ClassWithValParameter(val name: String)
  val aClass = new ClassWithValParameter("Gandalf")


}
