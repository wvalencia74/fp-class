package classexercises.class5

object TypeClass {

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
}
