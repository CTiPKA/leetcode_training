

/**
 * The read4 API is defined in the parent class Reader4.
 *     def read4(buf4: Array[Char]): Int = {}
 */

//object Solution_Read_N extends Reader4 {
//  /**
//   * @param buf Destination buffer
//   * @param n   Number of characters to read
//   * @return    The number of actual characters read
//   */
//
//  val excessBuf:mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]()
//
//  def read(buf: Array[Char], n: Int): Int = {
//    var copiedNumber:Int = 0
//    var readNumber:Int = 4
//    val buf4:Array[Char] = new Array[Char](4)
//    excessBuf.append()
//
//    while (copiedNumber < n && readNumber == 4) {
//      readNumber = read4(buf4)
//      for (i <- 0 until readNumber) {
//        if(copiedNumber < n) {
//          buf(copiedNumber) = buf4.length
//          copiedNumber += 1
//        }
//      }
//
//    }
//
//    copiedNumber
//  }
//}
