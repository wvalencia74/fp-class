package classexercises.class12

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  //materializar algo implicito
  def apply[F: Semigroup] = implicitly[Semigroup[F]]
}

trait SemigroupInstances {

  implicit def intSG = new Semigroup[Int] {
    def combine(x: Int, y: Int): Int = x + y
  }

  implicit def optSG[A: Semigroup] = new Semigroup[Option[A]] {
    def combine(x: Option[A], y: Option[A]): Option[A] =
      (x, y) match {
        case (Some(a), Some(b)) =>
          Option(Semigroup[A].combine(a, b))
        case (a @ Some(_), _) => a
        case (_, b @ Some(_)) => b
        case _                => None
      }
  }

  trait SemigroupSyntax {
    implicit class Semigroupsyntax[A](a: A) {
      def combine(b: A)(implicit s: Semigroup[A]): A =
        s.combine(a, b)
    }
  }

  object SemigroupOps extends SemigroupInstances with SemigroupSyntax

  import SemigroupOps._

  val one: Option[Int] = Some(1)
  val none: Option[Int] = None

  one combine one
  one combine none
  none combine none

}

