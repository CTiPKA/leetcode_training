import scala.collection.mutable

object Solution_CourseSchedule {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val courseSchedule = new Array[Int](numCourses)
    val workingQueue = mutable.ArrayBuffer[Int]()
    val prereqCounter = new Array[Int](numCourses)
    val topology = mutable.HashMap[Int,mutable.ArrayBuffer[Int]]()

    for (prereq <- prerequisites) {
      val mainCourse = prereq(0)
      val prereqCourse = prereq(1)
      val mainCourcesArr:mutable.ArrayBuffer[Int] = if(topology.contains(prereqCourse)) {
        topology(prereqCourse)
      } else {
        mutable.ArrayBuffer[Int]()
      }

      /** Add new main course for current prereq */
      mainCourcesArr += mainCourse
      topology.put(prereqCourse, mainCourcesArr)

      /** increase prerequisite for main course */
      prereqCounter(mainCourse) += 1
    }

    for (i <- 0 until numCourses) {
      if (prereqCounter(i) == 0) {
        workingQueue += i
      }
    }

    var i = 0
    if (workingQueue.nonEmpty) {
      while (workingQueue.nonEmpty) {
        /** processing  nodes with 0 prereq */
        val node = workingQueue(0)
        workingQueue.remove(0)
        /** write course processed in queue to schedule */
        courseSchedule(i) = node
        i += 1

        /** decrease linked main courses */
        if (topology.contains(node)) {
          for (mainCourse <- topology(node)) {
            prereqCounter(mainCourse) -= 1

            /** add to queue if no more prereq */
            if (prereqCounter(mainCourse) == 0) workingQueue += mainCourse
          }
        }
      }
    }

    if (i == numCourses) {
      courseSchedule
    } else {
      /** looks like have some circle dependencies */
      Array()
    }

  }
}
