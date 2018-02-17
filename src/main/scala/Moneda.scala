
sealed trait Moneda
case class Pesos(value:Double) extends Moneda
case class Dolar(value:Double) extends Moneda
case class Libra(value:Double) extends Moneda
case class Yen(value: Double) extends Moneda

def toPesos(m:Moneda, trms:List[(Moneda,Double)], toFind: (Double, List[(Moneda,Double)]) => Double):Double = {
  m match {
    case usd @ Dolar(v) => toFind(v, trms)
    case libra @ Libra(v) => toFind(v, trms)
    case yen @ Yen(v) => v* toFind(v, trms)
  }
}

def findTrms(v:Double,trms:List[(Moneda,Double)]):Double = {
  trms.find{
    case(Dolar(v)) => true
  }.get._2
}

