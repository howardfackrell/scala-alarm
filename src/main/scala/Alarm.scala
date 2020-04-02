import scala.concurrent.{Future, Promise, TimeoutException}
import scala.concurrent.ExecutionContext.Implicits.global

object Alarm {
  def main(args: Array[String]): Unit = {

    val xpression = Promise[Unit]()
    Future{
      Thread.sleep(200)
      throw new TimeoutException("this is taking a long time")
    } onFailure {
      case e: TimeoutException if (!xpression.isCompleted) => println(e.getMessage)
    }

    println("starting")
    Thread.sleep(1000)
    xpression.success()
    println("complete")


    Thread.sleep(1000)
  }

}
