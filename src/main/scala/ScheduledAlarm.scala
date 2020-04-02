import akka.actor.Status.Success
import akka.actor.{ActorSystem, Terminated}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.duration.MILLISECONDS

object ScheduledAlarm {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem.create("ActorSystem")

    val alarm = system.scheduler.scheduleOnce(Duration.create(200, MILLISECONDS), new Runnable {
      override def run(): Unit = {
        println("this is taking a long time")
      }
    })

    println("starting")
    Thread.sleep(1000)
    alarm.cancel()
    println("finished")

    Thread.sleep(1000)

    system.terminate().onSuccess {
      case t: Terminated => println("Actor system stopped")
    }
  }

}
