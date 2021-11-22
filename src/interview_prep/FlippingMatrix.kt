package interview_prep


fun main() {
  val arr = arrayOf(
    arrayOf(1,2,3,4),
    arrayOf(5,6,7,8),
    arrayOf(9,10,11,12),
    arrayOf(13,14,15,16),
  )
  println(arr.diagonalSum(1))
  println(arr.diagonalSum(2))
  println(arr.diagonalSum(3))
  println(arr.diagonalSum(4))
}

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
  // Write your code here

  TODO()
}

fun Array<Array<Int>>.flipHorizontally(row: Int) {
  this[row].reverse()
}
fun Array<Array<Int>>.flipVertically(column: Int) {
  val mid = (size/2) -1
  if(mid < 0) return
  var j = lastIndex
  for(i in 0..mid) {
    val temp = this[i][column]
    this[i][column] = this[j][column]
    this[j--][column] = temp
  }
}

fun Array<Array<Int>>.diagonalSum(quadrant: Int): Int {
  fun x(i: Int) = when(quadrant) {
    1,3 -> i
    else -> i + size/2
  }
  fun y(i: Int) = when(quadrant) {
    1,2 -> i
    else -> i + size/2
  }

  var sum = 0
  for(i in 0 until size/2) {
    for(u in 0 until size/2) {
      sum += this[y(i)][x(u)]
    }
  }
  return sum
}