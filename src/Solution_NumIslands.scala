
object Solution_NumIslands {

  class NumIslandsCalculation {
    private var grid: Array[Array[Char]] = Array()
    def numIslands(gridToCalc: Array[Array[Char]]): Int = {
      grid = gridToCalc
      var islands = 0
      val rows = grid.length
      val columns = grid(0).length
      for (row <- 0 until rows) {
        for (column <- 0 until columns) {
          if (grid(row)(column) == '1') {
            /** found root. marking island mass */
            markIslandMass(row, column)
            println(s"islands += 1. islands = $islands")
            islands += 1
          }
        }
      }
      islands
    }

    private def markIslandMass(rootRow: Int, rootColumn: Int): Unit = {
      println(s"$rootRow:$rootColumn: Found '1', marking as '0'")
      grid(rootRow)(rootColumn) = '0'
      if (rootRow - 1 >= 0 && grid(rootRow - 1)(rootColumn) == '1') {
        /** top cell */
        markIslandMass(rootRow - 1, rootColumn)
      }
      if (rootColumn - 1 >= 0 && grid(rootRow)(rootColumn - 1) == '1') {
        /** left cell */
        markIslandMass(rootRow, rootColumn - 1)
      }
      if (rootColumn + 1 < grid(rootRow).length && grid(rootRow)(rootColumn + 1) == '1') {
        /** right cell */
        markIslandMass(rootRow, rootColumn + 1)
      }
      if (rootRow + 1 < grid.length && grid(rootRow + 1)(rootColumn) == '1') {
        /** bottom cell */
        markIslandMass(rootRow+1, rootColumn)
      }

    }
  }

  def numIslands(grid: Array[Array[Char]]): Int = {
   val numIslandsCalc = new NumIslandsCalculation()
    numIslandsCalc.numIslands(grid)
  }
}
