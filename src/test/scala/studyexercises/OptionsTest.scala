package studyexercises

import org.scalatest.{AsyncWordSpec, Matchers}


class OptionsTest extends AsyncWordSpec with Matchers{

  val aa: Option[Int] = Option{println("2"); 2}
  val bb = Option(3)
  val none = None

  "Con algunos ejercicios sobre option" should {

    "sumar dos option con un for comprehension" in {
      Options.sumTwoOptions(aa, bb) shouldBe Some(5)
    }

    "con el for comprehension evalua a None si mandamos un None" in {
      Options.sumTwoOptions(None, bb) shouldBe None
    }

    "operar un option con flatmap" in {
      Options.sumTwo(bb) shouldBe Some(5)
      Options.sumTwo(None) shouldBe None
    }

    "obtener un valor al operar con un fold" in {
      bb.fold(0)(x => x+2) shouldBe 5
      none.fold(0)(x => x) shouldBe 0
    }

    "operar un valor con map" in {
      bb.map(_*3) shouldBe Some(9)
    }

  }
}
