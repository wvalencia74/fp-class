package classexercises.class2

object TestObject {

  object testObj {

    //Evalumos la diferencia entre un val y un método dentro de un objeto
    //Al imprimir estos valores en el val sólo se imprime la primera vez.
    val simpleField = {
      println("Evaluando el field")
      42
    }

    def method= {
      println("Evaluando el metodo")
      42
    }
  }
}

