import org.scalatest.funspec.AnyFunSpec

class Solution_NumIslandsSpec extends AnyFunSpec {

  describe("Solution_NumIslandsSpec") {
    it("should numIslands 1") {
      val line1 = Array[Char]('1', '1', '1', '1', '0')
      val line2 = Array[Char]('1', '1', '0', '1', '0')
      val line3 = Array[Char]('1', '1', '0', '0', '0')
      val line4 = Array[Char]('0', '0', '0', '0', '0')
      val grid = Array[Array[Char]](line1, line2, line3, line4)

      val numIslands = Solution_NumIslands.numIslands(grid)
      println(s"numIslands: $numIslands")
      assert(numIslands == 1)
    }
  }

  describe("Solution_NumIslandsSpec 2") {
    it("should numIslands 1.1") {
      val line1 = Array[Char]('1')
      val grid2 = Array[Array[Char]](line1)

      val solution = Solution_NumIslands
      val numIslands = Solution_NumIslands.numIslands(grid2)
      println(s"numIslands: $numIslands")
      assert(numIslands == 1)
    }
  }

  describe("Solution_NumIslandsSpec 3") {
    it("should numIslands 3") {
      val line1 = Array[Char]('1', '1', '0', '0', '0')
      val line2 = Array[Char]('1', '1', '0', '0', '0')
      val line3 = Array[Char]('0', '0', '1', '0', '0')
      val line4 = Array[Char]('0', '0', '0', '1', '1')
      val grid3 = Array[Array[Char]](line1, line2, line3, line4)

      val numIslands = Solution_NumIslands.numIslands(grid3)
      println(s"numIslands: $numIslands")
      assert(numIslands == 3)
    }

    it("should numIslands 5") {
      val line1 = Array[Char]('1', '1', '0', '1', '1')
      val line2 = Array[Char]('1', '1', '0', '1', '0')
      val line3 = Array[Char]('0', '0', '1', '0', '0')
      val line4 = Array[Char]('1', '0', '0', '1', '1')
      val grid3 = Array[Array[Char]](line1, line2, line3, line4)

      val numIslands = Solution_NumIslands.numIslands(grid3)
      println(s"numIslands: $numIslands")
      assert(numIslands == 5)
    }
  }

    describe("Solution_NumIslandsSpec 2") {
    it("should numIslands 2") {
      val line1 = Array[Char]('1','1','0','0','0')
      val line2 = Array[Char]('1','1','0','1','1')
      val line3 = Array[Char]('0','0','1','1','0')
      val line4 = Array[Char]('0','0','0','1','1')
      val grid = Array[Array[Char]](line1, line2, line3, line4)

      val numIslands = Solution_NumIslands.numIslands(grid)
      println(s"numIslands: $numIslands")
      assert(numIslands==2)
    }


    it("should numIslands 2.1") {
      val line0 = Array[Char]('1','1','0','0','0')
      val line1 = Array[Char]('1','1','0','1','1')
      val line2 = Array[Char]('0','0','1','1','0')
      val line3 = Array[Char]('0','1','1','1','1')
      val line4 = Array[Char]('1','1','0','1','1')
      val grid = Array[Array[Char]](line0, line1, line2, line3, line4)

      val numIslands = Solution_NumIslands.numIslands(grid)
      println(s"numIslands: $numIslands")
      assert(numIslands==2)
    }

      it("should numIslands 3") {
        val line1 = Array[Char]('1','1','0','0','0')
        val line2 = Array[Char]('1','1','0','1','1')
        val line3 = Array[Char]('0','0','1','1','0')
        val line4 = Array[Char]('0','1','1','0','1')
        val line5 = Array[Char]('1','1','0','1','1')
        val grid = Array[Array[Char]](line1, line2, line3, line4, line5)

        val numIslands = Solution_NumIslands.numIslands(grid)
        println(s"numIslands: $numIslands")
        assert(numIslands==3)
      }
  }
}
