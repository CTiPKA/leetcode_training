import org.scalatest.funspec.AnyFunSpec

class Solution_WaterAndJugSpec extends AnyFunSpec {

  describe("tests"){
    it("first"){
      val result = Solution_WaterAndJug.canMeasureWater(1,2,3)
      assert(result)
    }

    it("second"){
      val result = Solution_WaterAndJug.canMeasureWater(3,5,4)
      assert(result)
    }

    it("third"){
      val result = Solution_WaterAndJug.canMeasureWater(2,6,5)
      assert(!result)
    }

    it("4th"){
      val result = Solution_WaterAndJug.canMeasureWater(104659,104677,142424)
      assert(result)
    }

    it("5th"){
      val result = Solution_WaterAndJug.canMeasureWater(5,7,4)
      assert(result)
    }

    it("6th"){
      val result = Solution_WaterAndJug.canMeasureWater(5,7,11)
      assert(result)
    }
  }

  describe("tests v2"){
    it("first"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(1,2,3)
      assert(result)
    }

    it("second"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(3,5,4)
      assert(result)
    }

    it("third"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(2,6,5)
      assert(!result)
    }

    it("4th"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(104659,104677,142424)
      assert(result)
    }

    it("5th"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(5,7,4)
      assert(result)
    }

    it("6th"){
      val result = Solution_WaterAndJug.canMeasureWaterV2(5,7,11)
      assert(result)
    }
  }

}
