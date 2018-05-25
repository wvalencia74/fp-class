package classexercises.class4

import scala.util.{Failure, Success, Try}

object OptionExercises {

  val s:Option[Int] = None
  s.map(_*2)
  s.flatMap(x => Option(x*2))
  s.fold(0)(x => x+2)
  //l.sum/l.size

  val a: Option[Int] = Option{println("2"); 2}
  val b = Option(3)

  for {
    ss <- a
    bb <- b
  } yield ss+bb

  trait MensajeError{val error:String}
  trait Estado
  trait Cifrado extends Estado
  trait Plano extends Estado

  trait ShaError{val error:String}

  //validar mensaje, sino None
  case class Mensaje(texto:String, sha:Int)
  object Mensaje{
    def apply(texto:String, sha:Int): Either[MensajeError,Mensaje ] = {
      for{
        sha <- validarSha(sha)
      }yield new Mensaje(texto, sha)
      //if(validarSha(sha)) Right(new Mensaje(texto, sha))
      //else Left(new MensajeError{val error = "Bad sha"})
    }

  private def validarSha(sha:Int):Either[ShaError, Int] = {
    if(sha!=0) Right(sha)
    else Left(new ShaError {val error = "Sha es igual a 0"})
  }


  /*object MensajeServices{
    def cifrar(m:Mensaje):Mensaje = new Mensaje()
  }*/

  /*def cifrar(m:Mensaje):Mensaje = m
  Mensaje("M",1).fold*/



}

  object ExercisesClass4 {

    case class A(a: Int, b: Int)

    val a = A(1, 2)

    a.copy(a.a + 1, a.b + 1)

    val ab = a match {
      case A(b, c) => A(b + 1, c + 1)
    }

    val l1 = (1 to 4).toList

    def sumElemen(li: List[Int]): List[Int] = {
      li match {
        case h :: Nil => (h + 1) :: Nil
        case h :: t   => (h + 1) :: sumElemen(t)
        case _        => Nil
      }
    }

    def sumSafe(l: List[Int]): List[Int] = {
      @tailrec
      def sumElemenSafe(elm: List[Int], acc: List[Int]): List[Int] = {
        elm match {
          case h :: Nil => acc :+ (h + 1)
          case h :: t   => sumElemenSafe(t, acc :+ (h + 1))
          case Nil      => acc
        }
      }
      sumElemenSafe(l, Nil)
    }

    def prom(l: List[Double]): Double = {
      @tailrec
      def promSafe(elm: List[Double], acc: Double, size: Double): Double = {
        elm match {
          case h :: t => promSafe(t, h + acc, size + 1)
          case Nil    => acc / size
        }
      }
      l match {
        case Nil => 0.0
        case _   => promSafe(l, 0.0, 0.0)
      }
    }

    case class Mensaje(texto: String, sha: Int)
    object Mensaje {
      def apply(texto: String, sha: Int): Option[Mensaje] = {
        if (validarSha(sha)) Option(new Mensaje(texto, sha))
        else None
      }

      private def validarSha(sha: Int): Boolean = ???
    }

    case class Mensaje2(texto: String, sha: Int)
    object Mensaje2 {
      def apply(texto: String, sha: Int): Try[Mensaje2] = {
        if (validarSha(sha)) Success(new Mensaje2(texto, sha))
        else Failure(new Exception)
      }
      private def validarSha(sha: Int): Boolean = ???
    }

    val cc = for {
      r <- Left(1)
      c <- Right(3)
    } yield c + c

    trait MensajeError { val error: String }
    case class InvalidSha(error: String = "Invalid Sha") extends MensajeError
    case class InvalidText(error: String = "Invalid Text") extends MensajeError

    sealed trait Estado
    trait Cifrado extends Estado
    trait Plano extends Estado

    case class Mensaje3[S <: Estado](texto: String, sha: Int)
    object Mensaje3 {
      def apply(texto: String,
                sha: Int): Either[MensajeError, Mensaje3[Plano]] = {
        for {
          sha <- validarSha(sha)
          text <- validarTexto(texto)
        } yield new Mensaje3[Plano](text, sha)
      }
      private[this] def validarSha(sha: Int): Either[MensajeError, Int] = {
        if (sha % 2 != 0) Left(InvalidSha())
        else Right(sha)
      }
      private[this] def validarTexto(
                                      texto: String): Either[MensajeError, String] = {
        if (texto.isEmpty) Left(InvalidText())
        else Right(texto)
      }
    }

    object MensajeServices {
      def cifrar(m: Mensaje3[Plano]): Mensaje3[Cifrado] =
        new Mensaje3[Cifrado](m.texto, m.sha)
    }

  }