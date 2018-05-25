package classexercises.class4

import scala.annotation.tailrec


object Listas {

  def addOne(l: List[Int]):List[Int] = {
    l match {
      case h :: Nil => (h + 1) :: Nil
      case h :: t => (h + 1) :: addOne(t)
      case Nil => Nil
    }
  }

  def addR(l: List[Int]):List[Int] = {
    @tailrec
    def addLoop(elem: List[Int], acc:List[Int]): List[Int] = {
      elem match {
        case h :: Nil => acc :+ (h+1)
        case h :: t => addLoop(t, acc:+ (h+1))
        case Nil => Nil
      }
    }
    addLoop(l, Nil)
  }

  def obtenerPromedio(list: List[Int]):Double= {
    val tam = hallarTamañoR(list)
    tam._1/tam._2
  }

  def hallarTamañoR(elementos: List[Int]): (Int,Double) ={
    @tailrec
    def hallarTamaño(elem: List[Int], acc:Int, cant:Double): (Int,Double) = {
      elem match {
        case h :: t => hallarTamaño(t, acc+h, cant+1)
        case Nil => (acc,cant)
      }
    }
    hallarTamaño(elementos, 0, 0L)
  }

}