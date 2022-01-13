import scala.collection.mutable

class MaxStack() {
  var stackIndex:Int
  val stack = mutable.ArrayBuffer[Long]()
  val stackOrdering:Ordering[Int] = Ordering.by[Int,Int](element => element)
  val maxElementPriorityQ:mutable.PriorityQueue[Int]=mutable.PriorityQueue[Int]()(stackOrdering)

  def push(x: Int) {
    stack.push(x)
    maxElementPriorityQ.enqueue(x)
  }

  def pop(): Int = {
    stack.pop()
  }

  def top(): Int = {
    stack.top
  }

  def peekMax(): Int = {
    maxElementPriorityQ.head
  }

  def popMax(): Int = {
    val maxElement = maxElementPriorityQ.dequeue()
    stack.
  }

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * var obj = new MaxStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.peekMax()
 * var param_5 = obj.popMax()
 */