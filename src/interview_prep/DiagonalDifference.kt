package interview_prep

import kotlin.math.absoluteValue


fun diagonalDifference(arr: Array<Array<Int>>): Int {
  // Write your code here
  var d1 = 0
  var d2 = 0

  for(i in arr.indices) {
    d1 += arr[i][i]
    d2 += arr[i][arr.size -i -1]
  }
  return (d1 - d2).absoluteValue
}