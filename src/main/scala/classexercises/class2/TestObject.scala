package classexercises.class2

object TestObject {

  object testObj {
    val simpleField = {
      println("Evaluando el field")
      42
    }
    def sinParametro = {
      println("Evaluando el metodo")
      42
    }
  }
}

