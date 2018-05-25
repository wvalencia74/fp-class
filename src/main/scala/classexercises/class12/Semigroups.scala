package classexercises.class12

/*object Semigroups {
  def combine(a:Option[Int], b:Option[Int]) = a {
    case Some(s) =>  s + b{case Some(z) => z}
    //case Some(s) =>  s + b{case Some(z) => z}

  }
}

trait Semigroup[A] {
  def combine(a:A, b:A):A
}

object semigroup{
  //materializar algo implicito
  def apply[F: Semigroup] = implicitly[Semigroup[F]]
}

trait SemigroupInstances {
  implicit def intSG = new Semigroup[Int] {
    def combine(x:Int, y:Int) = x + y
  }

  implicit def optSG[A:Semigroup] =
    new Semigroup[Option[A]] {
      def combine(x:Option[A], y:Option[A]):Option[A] =
        (x,y) match {
          //case(Some(a), Some(b)) => Option(Semigroup[A].combine(a,b))
          case (a @ Some(_), _) =>  a
          case (_, b @ Some(_)) => b
        }
    }

}

trait SemigroupSyntex {
  implicit class SemigroupSyntax[A](a:A){
    def combine(b:A)(implicit  s:Semigroup[A]): A = s.combine(a, b)
   }
}*/

