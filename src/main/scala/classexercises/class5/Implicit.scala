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
}
