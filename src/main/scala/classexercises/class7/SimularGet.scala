package classexercises.class7

import scala.concurrent.Future

object SimularGet {

  sealed trait Error {
    val description:String
  }

  case class TechnicalError(description:String = "Technical Error") extends Error
  case class BusinessError(description:String = "Business Error") extends Error
  case class EmptyId(description:String = "The id field is empty") extends Error
  case class EmptyName(description:String = "The name field is empty") extends Error
  case class EmptyLastName(description:String = "The lastName field is empty") extends Error

  final case class Id(id:String)
  object Id{
    def apply(id: Option[String]): Either[Error, Id] =
      id match {
        case Some(ident) => Right(new Id(ident))
        case _ => Left(EmptyId())
      }
  }

  final case class Nombre(name:String)
  object Nombre{
    def apply(name: Option[String]) = {
      name match {
        case Some(name) => Right(new Nombre(name))
        case _ => Left(EmptyName)
      }
    }
  }

  final case class Apellido(lastName:String)
  object Apellido{
    def apply(lastName: Option[String]) = {
      lastName match {
        case Some(lastName) => Right(new Apellido(lastName))
        case _ => Left(EmptyLastName)
      }
    }
  }

  final case class Telefono(tel:String)
  object Telefono{
    def apply(tel: Option[String]): Either[Error, Telefono] = {
      tel match {
        case Some(tel) => Right(new Telefono(tel))
        case _ => Right(new Telefono(""))
      }
    }
  }

  case class Usuario(id:Id, nombre:Nombre, apellido:Apellido, telefono:Telefono)
  object Usuario {
    def apply(ident: Option[String], nombre: Option[String], apellido: Option[String], telefono: Option[String]) = {

      for {
        identif  <- Id(ident)
        name     <- Nombre(nombre)
        lastName <- Apellido(apellido)
        telefono <- Telefono(telefono)
      } yield {
        new Usuario(identif, name, lastName, telefono)
      }
    }

    //def apply(id: String, nombre: String, ): Usuario = new Usuario(id, nombre, None)
  }

  def getId(): Future[Option[String]] ={
    Future(Option("12345"))
  }

  def getNombre(): Future[Option[String]] = {
    Future(Option("Andrea"))
  }

  def getApellido(): Future[Option[String]] = {
    Future(Option("Gaviria"))
  }

  def getTelefono(): Future[Option[String]] = {
    Future(Option("2334565"))
  }

  def getUsuario()= {
    for{
      id       <- getId()
      name     <- getNombre()
      lastName <- getApellido()
      tel      <- getTelefono()
    } yield {
        Usuario(id,name,lastName,tel)
    }

    /*user.map {
      case user@Some(Usuario(id, nombre, apellido, _)) => Right(user.orNull)
      case None => Left(TechnicalError())
    }*/
  }



}
