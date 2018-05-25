package studyexercises

object Options {

  def sumTwoOptions(a:Option[Int], b:Option[Int]): Option[Int] = {
    for {
      aa <- a
      bb <- b
    }yield aa + bb
  }

  def sumTwo(x:Option[Int]) = x.flatMap(x => Option(x+2))


  //s.map(_*2)
}
