import org.scalatest.funspec.AnyFunSpec

class Solution_CourseScheduleTest extends AnyFunSpec {

  describe("test schedule") {
    it("first") {
      val cources = Array(Array(1,0))
      val expectedResult = Array(0,1)
      val schedule = Solution_CourseSchedule.findOrder(2, cources)

      assert(schedule sameElements expectedResult, "Wrong!")
    }

    it("second") {
      val cources = Array(Array(1,0),Array(2,0),Array(3,1),Array(3,2))
//      val expectedResult = Array(0,2,1,3)
      val expectedResult = Array(0,1,2,3)
      val schedule = Solution_CourseSchedule.findOrder(4, cources)

      println(s"schedule: ${schedule.mkString("Array(", ", ", ")")}")
      println(s"expectedResult: ${expectedResult.mkString("Array(", ", ", ")")}")

      assert(schedule sameElements expectedResult, "Wrong!")
    }

  }

}
