import scala.collection.mutable

class TimeMap() {
  private val objectsHashMap:mutable.HashMap[String,mutable.HashMap[Int,String]] = mutable.HashMap[String,mutable.HashMap[Int,String]]()

  def set(key: String, value: String, timestamp: Int):Unit = {
    if (objectsHashMap.contains(key)) {
      objectsHashMap(key).put(timestamp,value)
    } else {
      val timeObjectsNew:mutable.HashMap[Int,String] = mutable.HashMap[Int,String]()
      timeObjectsNew.put(timestamp,value)
      objectsHashMap.put(key,timeObjectsNew)
    }
  }

  def get(key: String, timestamp: Int): String = {
    if (objectsHashMap.contains(key)) {
      val timeObjects = objectsHashMap(key)
      for (i <- timestamp to 0 by -1) {
        if (timeObjects.contains(i)) {
          return timeObjects(i)
        }
      }
      /** not found value for i == timestamp or less  */
      ""
    } else {
      ""
    }
  }

}