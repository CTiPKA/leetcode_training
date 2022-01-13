
import org.scalatest.funspec.AnyFunSpec

class Solution_AsteroidsCollisionsTest extends AnyFunSpec {

  describe("asteroids test") {
    it("[5,10,-5]") {
      val asteroids = Array(5, 10, -5)
      val result = Solution_AsteroidsCollisions.asteroidCollision(asteroids)

      val expectedResult = Array(5, 10)
      println(s"result: ${result.mkString("Array(", ", ", ")")}")
      println(s"expectedResult: ${expectedResult.mkString("Array(", ", ", ")")}")
      assert(result sameElements expectedResult)
    }

    it("[10,2,-5]") {
      val asteroids = Array(10, 2, -5)
      val result = Solution_AsteroidsCollisions.asteroidCollision(asteroids)

      val expectedResult = Array(10)
      println(s"result: ${result.mkString("Array(", ", ", ")")}")
      println(s"expectedResult: ${expectedResult.mkString("Array(", ", ", ")")}")
      assert(result sameElements expectedResult)
    }
  }
}
