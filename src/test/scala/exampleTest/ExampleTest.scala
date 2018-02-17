package exampleTest
import org.scalatest.FunSuite

class ExampleTest extends FunSuite {

  test("Define a simple val") {

    val home = "home" + 2

    assert(home.size.equals(5))
    assert(home.equalsIgnoreCase("home2"));
  }

  test("Test functions") {

    def writePretty(a:Int) = "Esto es un: " + a

    def ordenizePreviewPrint(x:String, a:Int): String = writePretty(a) + x

    def findArea(l:Double) = l*4
    val areaOfFour = findArea(4)

    assert(!writePretty(3).isEmpty)
    assert(ordenizePreviewPrint(" gracias!", 3).equalsIgnoreCase("Esto es un: 3 gracias!"))
    assert(areaOfFour.equals(16.0))

  }

  test("pruba max div"){

  }

}
