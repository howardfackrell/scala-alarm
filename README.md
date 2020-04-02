# scala-alarm

Demonstrates a couple of approaches to triggering an alert on a 
long running process in scala

## Alarm
The Alarm class uses promises, futures, and Thread.sleep to alert if an async process is taking too long

## ScheduledAlarm
The ScheduledAlarm class uses an akka system schduler instead of the Thread.sleep(). Probably a better
approach than the first, unless you need to avoid akka for some reason.