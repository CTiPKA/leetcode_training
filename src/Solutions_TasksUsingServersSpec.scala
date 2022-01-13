import org.scalatest.funspec.AnyFunSpec

class Solutions_TasksUsingServersSpec extends AnyFunSpec {

  describe("tasks testing") {
    it("first test") {
      val servers = Array(3,3,2)
      val tasks = Array(1,2,3,2,1,2)
      val expectedResult = Array(2,2,0,2,1,2)

      val result = Solutions_TasksUsingServers.assignTasks(servers, tasks)

      println(s"result: ${result.mkString("Array(", ", ", ")")}")

      assert(result sameElements expectedResult)

    }
  }

}
