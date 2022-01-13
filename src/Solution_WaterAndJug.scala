import scala.annotation.tailrec
import scala.collection.mutable

object Solution_WaterAndJug {
  def canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean = {
    if (jug1Capacity + jug2Capacity < targetCapacity) return false
    val gcdResult = if (jug1Capacity > jug2Capacity) {
      gcd(jug1Capacity, jug2Capacity)
    }  else {
      gcd(jug2Capacity, jug1Capacity)
    }

    println(s"final result. $targetCapacity % $gcdResult = ${targetCapacity % gcdResult == 0}")
    targetCapacity % gcdResult == 0
  }

  @tailrec
  private def gcd(n1: Int, n2: Int): Int = {
    /** GCD — greatest common divisor */
    if (n2 == 0) {
      println(s"found gcd = $n1")
      n1
    } else {
      println(s"$n1 % $n2 = ${n1 % n2}")
      gcd(n2, n1 % n2)
    }
  }

  class CanMeasureV2 {
    var jug1MaxCapacity:Int = 0
    var jug2MaxCapacity:Int = 0
    var target:Int = 0
    var history: mutable.HashMap[String, Int] = mutable.HashMap()
    var queue: mutable.ArrayBuffer[(Int, Int)] = mutable.ArrayBuffer[(Int, Int)]()

    def canMeasure(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean = {
      jug1MaxCapacity = jug1Capacity
      jug2MaxCapacity = jug2Capacity
      target = targetCapacity

      /** add root case */
      history("00") = 1
      queue.append((0, 0))

      var result = false
      while (queue.nonEmpty) {
        val option = queue(0)
        queue.remove(0)
        println(s"Option processing: ${option._1}, ${option._2}")
        val currentJug1 = option._1
        val currentJug2 = option._2
        if (currentJug1 + currentJug2 == target) {
          return true
        } else {
          val options: mutable.ArrayBuffer[(Int, Int)] = mutable.ArrayBuffer[(Int, Int)]()
          /** empty jug */
          options.append(Tuple2(currentJug1, 0))
          options.append(Tuple2(0, currentJug2))
          /** fill jug */
          options.append(Tuple2(currentJug1, jug2MaxCapacity))
          options.append(Tuple2(jug1MaxCapacity, currentJug2))
          /** pour jug1 to jug2 */
          var jug1 = if (currentJug1 + currentJug2 > jug2MaxCapacity) (currentJug1 + currentJug2) - jug2MaxCapacity else 0
          var jug2 = if (currentJug1 + currentJug2 > jug2MaxCapacity) jug2MaxCapacity else currentJug1 + currentJug2
          options.append(Tuple2(jug1, jug2))

          /** pour jug2 to jug1 */
          jug1 = if (currentJug1 + currentJug2 > jug1MaxCapacity) jug1MaxCapacity else currentJug1 + currentJug2
          jug2 = if (currentJug1 + currentJug2 > jug1MaxCapacity) (currentJug1 + currentJug2) - jug1MaxCapacity else 0
          options.append(Tuple2(jug1, jug2))

          options.foreach({ optionNew =>
            if (!history.contains(s"$optionNew._1,$optionNew._2")) {
              history(s"$optionNew._1,$optionNew._2") = 1
              println(s"Option added: ${optionNew._1}, ${optionNew._2}")
              queue.append(optionNew)
            }
          })
        }
      }
      result
    }
  }

  def canMeasureWaterV2(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean = {
    val canMeasureV2 = new CanMeasureV2()
    canMeasureV2.canMeasure(jug1Capacity, jug2Capacity, targetCapacity)
  }

}
