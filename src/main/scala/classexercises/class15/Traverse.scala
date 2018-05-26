package classexercises.class15

import scala.concurrent.{ Future}
import scala.concurrent.ExecutionContext.Implicits.global

object Traverse {

  trait User
  trait Address
  type Id = String

  case class FutOpt[A](value: Future[Option[A]]) {

    def map[B](f: A => B): FutOpt[B] =
      FutOpt(value.map(optA => optA.map(f)))

    def flatMap[B](f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(value.flatMap {
        case Some(a) => f(a).value
        case None => Future.successful(None)
      })
  }

  case class ListOp[A](value: List[Option[A]]) {

    def map[B](f: A => B): ListOp[B] =
      ListOp(value.map(opA => opA.map(f)))

    def flatMap[B](f: A => ListOp[B]): ListOp[B] =
      ListOp(value.flatMap(op =>
        op match {
          case Some(a) => f(a).value
          case None    => List(None)
        }))
  }

  def getUserById(id:Id):Future[Option[User]] = Future(throw new Exception("Error"))

  def findAddressByUser(user: User): Future[Option[Address]] = Future.successful(None)

  def findAddressByUserId(userId: String): Future[Option[Address]] =
    (for {
      user <- FutOpt(getUserById(userId))
      address <- FutOpt(findAddressByUser(user))
    } yield address).value

}






