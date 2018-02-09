package ExampleTest
import org.scalatest.FunSuite

/**
  * Created by william on 9/02/18.
  */

class ExampleTest extends FunSuite {

  test("Define a simple val") {

    val home = "home"
    assert(home.equalsIgnoreCase("home"));
  }

}
