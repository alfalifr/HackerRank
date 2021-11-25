package interview_prep

import kotlin.math.absoluteValue
import kotlin.math.min

fun main() {
  pairs(
    2,
    //arrayOf(1,2,3,4,5,7,8,10),
    arrayOf(1,2,3,4,5,7,8,10),
  )
}


//- 1 1
//1 2 3 4 5 6 7

fun pairs(k: Int, arr: Array<Int>): Int {
  // Write your code here
  //arr.groupBy { it }.values.find { it.size > 1 }
  if(arr.size == 2) {
    return if((arr[0] - arr[1]).absoluteValue == k) 1
    else 0
  }
  /*
  val isPresents = BooleanArray(Int.MAX_VALUE-1)
  var pairCount = 0
  for(i in arr.indices) {
    isPresents[arr[i]] = true
    val index = arr[i] + k
    if(index >= 0 && isPresents[index]) {
      pairCount++
    }
  }
   */
/*
  var pairCount = 0
  for(i in arr.indices) {
    var count = 0
    for(u in i+1 until arr.size) {
      if((arr[i] - arr[u]).absoluteValue == k) {
        pairCount++
        if(++count == 2) {
          break
        }
      }
    }
  }
// */
//*
  arr.sort()
  var pairCount = 0
  for(i in 0 until arr.size-1) {
    var count = 0
    val limit = min(i+k, arr.size-1)
    for(u in i+1 .. limit) {
      //println("i= $i u= $u arr[i] = ${arr[i]} arr[u] = ${arr[u]} limit= $limit")
      if((arr[i] - arr[u]).absoluteValue == k) {
        pairCount++
        if(++count == 2) {
          break
        }
      } else {
        val range = arr[i] + k
        if(arr[u] > range || range < 0) {
          break
        }
      }
    }
  }
// */
  //println("arr = ${arr.joinToString()}")
  //println(pairCount)
  return pairCount
}