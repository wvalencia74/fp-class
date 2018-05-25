package classexercises.class3

object Currency {

  sealed trait Moneda

  case class Pesos(valor: Double) extends Moneda
  case class Dolar(valor: Double) extends Moneda
  case class Libra(valor: Double) extends Moneda
  case class Yen  (valor: Double) extends Moneda

  def toPesos(m: Moneda, trms: List[(Moneda, Double)], toFind: (Double, List[(Moneda, Double)]) => Double): Double = {
    m match {
      case Dolar(v) => toFind(v, trms)
      case Libra(v) => toFind(v, trms)
      case Yen(v)   => toFind(v, trms)
    }
  }

  def findTrms(v:Double, trms:List[(Moneda,Double)]):Double = {
    v * trms.find{
      case(Dolar(_), _) => true
    }.get._2
  }

}