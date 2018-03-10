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
  /*case class Mensaje(texto:String, sha:Int)
  object Mensaje{
    def apply(texto:String, sha:Int): Either[MensajeError,Mensaje ] = {
      for{
        sha <- validarSha(sha)
      }yield new Mensaje(texto, sha)
      //if(validarSha(sha)) Right(new Mensaje(texto, sha))
      //else Left(new MensajeError{val error = "Bad sha"})
    }*/

  private def validarSha(sha:Int):Either[ShaError, Int] = {
    if(sha!=0) Right(sha)
    else Left(new ShaError {val error = "Sha es igual a 0"})
  }


  /*object MensajeServices{
    def cifrar(m:Mensaje):Mensaje = new Mensaje()
  }*/

  /*def cifrar(m:Mensaje):Mensaje = m
  Mensaje("M",1).fold*/



  Try[Int](1)
  Success(1)
  Failure(new Exception)


}
