package interview_prep.arrays

import util.IO

private const val fileName = "1_2dArrayDS.txt"

fun main() {

  val arr = Array(6) {
    val arr = IO.InterviewPrep.readLine(fileName)!!.trimEnd().split(" ").mapNotNull {
      //println("it= '$it'")
      if(it.isBlank()) {
        return@mapNotNull null
      }
      it.toInt()
    }.toTypedArray()
    assert(arr.size == 6)
    arr
  }
  val res = hourglassSum(arr)
  print(res)
}

fun hourglassSum(arr: Array<Array<Int>>): Int {
  //val arrSum = Array(6-2) { IntArray(6-2) }
  var maxSum = Int.MIN_VALUE
  for(i in 1 .. 6-2) { //Row
    for(u in 1 .. 6-2) { //Column
      //arrSum[i][u] =
      val arrSum =
        arr[i-1][u-1] +arr[i-1][u] +arr[i-1][u+1] +
        arr[i][u] +
        arr[i+1][u-1] +arr[i+1][u] +arr[i+1][u+1]
      if(maxSum < arrSum) {
        maxSum = arrSum
      }
    }
  }
  return maxSum
}