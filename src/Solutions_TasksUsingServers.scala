import scala.collection.mutable

case class Server(priority:Int, index:Int, endOfTask:Int)

object ServersOrdering extends Ordering[Server] {
  override def compare(x: Server, y: Server): Int = {
    if (x.priority == y.priority) {
      y.index compare x.index
    } else {
      y.priority compare x.priority
    }
  }
}

object Solutions_TasksUsingServers {
  def assignTasks(servers: Array[Int], tasks: Array[Int]): Array[Int] = {
    val serversPriorityQ:mutable.PriorityQueue[Server] = mutable.PriorityQueue[Server]()(ServersOrdering)
    val tasksOrdering:Ordering[Server] = Ordering.by[Server,Int](_.endOfTask).reverse
    val tasksPriorityQ:mutable.PriorityQueue[Server] = mutable.PriorityQueue[Server]()(tasksOrdering)
    val serversUsage:mutable.ArrayBuffer[Int] = mutable.ArrayBuffer[Int]()

    for (i<-servers.indices) {
      serversPriorityQ += Server(priority=servers(i), index=i, endOfTask=0)
    }

    var iterationSecond = 0
    var taskIndex = 0
    while (iterationSecond >= 0) {
      /** free server if any task(s) done */
      while (tasksPriorityQ.nonEmpty && tasksPriorityQ.head.endOfTask <= iterationSecond) {
        serversPriorityQ.enqueue(tasksPriorityQ.dequeue())
      }

      /** assign new task to server and adding to queue */
      while (serversPriorityQ.nonEmpty && taskIndex < iterationSecond && taskIndex < tasks.length) {
        val topServer = serversPriorityQ.dequeue()
        tasksPriorityQ.enqueue(Server(topServer.priority, topServer.index, iterationSecond + tasks(taskIndex)))
        serversUsage.append(topServer.index)
        taskIndex += 1
      }
      /** if no server just wait */

      if (taskIndex < tasks.length) {
        /** just go to the next second */
        iterationSecond += 1
      } else {
        /** processed all tasks */
        iterationSecond = -1
      }
    }

    serversUsage.toArray
  }
}

