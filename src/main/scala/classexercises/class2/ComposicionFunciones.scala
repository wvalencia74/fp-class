package classexercises.class2
import classexercises.class2.Factorial._

object ComposicionFunciones {

  val comp = (calcularFactorial _ andThen imprimirValor )(3)

  val comp2 = (imprimirValor _ compose calcularFactorial _ )(3)

  def toInt(s: String) = s.toInt
  def addOne(i: Int) = i + 1
  def by4(i: Int) = i * 4

  //Son equivalentes
  val compose = addOne _ compose toInt
  val compose2 = toInt _ andThen addOne
}
