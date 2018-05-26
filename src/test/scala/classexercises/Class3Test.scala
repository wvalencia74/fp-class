package classexercises

import classexercises.class3.Currency
import classexercises.class3.Currency.Dolar
import org.scalatest.{AsyncWordSpec, Matchers}

class Class3Test extends AsyncWordSpec with Matchers{

  val dolar = Dolar(2800.0)
  val list = List((dolar, 1.5))

  "Algunas operaciones sobre Currency" should {

    "poder encontrar el trs" in {
      println(Currency.findTrms(7000,list))
      Currency.findTrms(7000,list) shouldBe 10500.0
    }

  }

}
