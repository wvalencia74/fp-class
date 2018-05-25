package classexercises.class4


import scala.util.{Failure, Success, Try}

object ModelExercises {


  trait Estado
  trait Cifrado extends Estado
  trait Plano extends Estado

  trait MensajeError{val error:String}
  trait ShaError extends MensajeError

  //validar mensaje, sino None
  case class Mensaje(texto:String, sha:Int)
  object Mensaje{

    def apply(texto:String, sha:Int): Either[MensajeError, Mensaje] = {
      for{
        shaa <- validarSha(sha)
      }yield {
        new Mensaje(texto, shaa)
      }
    }

  private def validarSha(sha:Int):Either[ShaError, Int] = {
    if(sha!=0) Right(sha)
    else Left(new ShaError {val error = "Sha es igual a 0"})
  }}


  object MensajeServices{
    /*
    object MensajeServices {
      def cifrar(m: Mensaje3[Plano]): Mensaje3[Cifrado] =
        new Mensaje3[Cifrado](m.texto, m.sha)
    }
    def cifrar(m:Mensaje):Mensaje = m
    Mensaje("M",1).fold*/
  }



}