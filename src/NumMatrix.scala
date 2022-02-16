
/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
class NumMatrix(_matrix: Array[Array[Int]]) {
  private val matrix: Array[Array[Int]] = _matrix
  /** pre calculate sums of all matrix */
  private var precalcSums: Array[Array[Int]] = {
    val precalcSumTmp = Array.ofDim[Int](matrix.length+1, matrix(0).length+1)

    for (row <- 0 until matrix.length) {
      for (col <- 0 until matrix(0).length) {
        precalcSumTmp(row + 1)(col + 1) =
          precalcSumTmp(row)(col + 1) + precalcSumTmp(row + 1)(col) + matrix(row)(col) - precalcSumTmp(row)(col)
      }
    }
    precalcSumTmp
  }

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    precalcSums(row2+1)(col2+1) - precalcSums(row1)(col2+1) - precalcSums(row2+1)(col1) + precalcSums(row1)(col1)
  }


}
