
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

  class Point(x: Int, y: Int) {

    override def toString(): String = "(" + x + ", " + y + ")"
  }

  class ClassWithValParameter(val name: String)
  val aClass = new ClassWithValParameter("Gandalf")


}
