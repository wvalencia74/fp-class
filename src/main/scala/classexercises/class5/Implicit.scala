package classexercises.class5

object Implicit {

  case class Person(nombre:String, edad:Int)

  def sumWhatEver[T](a:T, b:T): T = ???

  def sumString(a:String)(b:String):String = a + b

  def sum : Int => Int => Int = a => b => a + b
  def sumNum(a:Int, b:Int):Int = a + b

  val s = sum(2)(2)
  val sss = sumString("h")( _:String)

  val and = new Person("Andrea", 23)
  implicit def getEdad: Person => Int = _.edad

  implicit val i:Int = 99
  def sump(a: Int)(implicit b:Int) = a + b

  object x { implicit val pi = 3.14}

  implicit def toS:Int => String = _.toString

  sumString("gg")(2)

  def prueba(a:String, b:String):Boolean= {
    if(a.size>b.size) true
    else false
  }

  implicit class StringOps(s:String) {
    def >== (s2:String):Boolean = s.length >= s2.length

  }

  "hola".>==("mundo")

  sealed trait Persona{
    val nombre:String
    val patrimonio:Int
  }

  case class PersonaNatural(nombre:String, patrimonio:Int) extends Persona
  case class PersonaJuridica(nombre:String, patrimonio:Int) extends Persona

  trait Sumable[T] {
    def sumar(a:T, b:T):T
    def zero:T
  }

  object SumableOps{
    implicit object IntSumable extends Sumable[Int] {
      def sumar(a:Int, b:Int): Int = a + b
      def zero = 0
    }

    implicit object sumPatrimonio extends Sumable[Persona]{
      def sumar(a:Persona, b:Persona):PersonaJuridica = {
        PersonaJuridica(nombre = "juridica", patrimonio = a.patrimonio + b.patrimonio)
      }
      def zero = PersonaJuridica("juridica", 0)
    }
  }

  import SumableOps._
  def sume[T](a:T, b:T)(implicit s: Sumable[T]):T = s.sumar(a,b)
  sume(1,2)
  def sumaa[T:Sumable](a:T, b:T): T = implicitly[Sumable[T]].sumar(a,b)

  //println(sume())
  //def sumaPatrimonio[T](a:T,b:T)(implicit s:Sumable[T]) = s.sumar(a,b)





}
