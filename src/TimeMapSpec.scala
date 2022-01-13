import org.scalatest.funspec.AnyFunSpec

class TimeMapSpec extends AnyFunSpec {

  describe("tests") {
    it("first") {

      val timeMap = new TimeMap()
      timeMap.set("foo", "bar", 1)

      val result1 = timeMap.get("foo", 1)
      println(result1)
      assert(result1 == "bar")

      val result2 = timeMap.get("foo", 3)
      println(result2)
      assert(result2 == "bar")

      timeMap.set("foo", "bar2", 4)

      val result3 = timeMap.get("foo", 4)
      println(result3)
      assert(result3 == "bar2")

      val result4 = timeMap.get("foo", 5)
      println(result4)
      assert(result4 == "bar2")

    }
  }


}
