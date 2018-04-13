package classexercises.class7

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success


object Futuros {

  val event = Future[Int]{
    Thread.sleep(5000)
    throw new Exception("Error")
  } map {x => x+1} recover {
    case ex => s"el error es ${ex.getMessage}"
  }

  //val event = Future(1)
  println("principal")
  val result = Await.result(event, 2.seconds)
  println("Await")
  //println(event.map(_+1))

  val _ = Thread.sleep(200)
  println(event)

  println(result)

  val f1:Future[Int] = Future(2)
  val f2:Future[Int] = Future(3)
  val f3:Future[Int] = Future(4)

  def sum(f11: Future[Int], f22: Future[Int], f33: Future[Int]): Future[Int] ={
    for {
      f1 <- f11
      f2 <- f22
      f3 <- f33
    } yield { f1 + f2 + f3}
  }

  def futureSeq() = {
    println("Inicio")

    val a = Future(1).map( _ => {
      println("UNO")
      1
    })

    val b = Future(1).map( _ => {
      println("DOS")
      2
    })

    val c = Future(1).map( _ => {
      println("TRES")
      3
    })

    val sum = for {
      aa <- Future.failed[Int](new Exception("Error uno"))
      bb <- Future.successful( 1 + aa)
      cc <- c map {tres => println("suma tres"); 1 + bb}
    } yield {
      println("Inside for")
      aa + bb + cc
    }
    println("finish for")
    println(sum)
  }




}
