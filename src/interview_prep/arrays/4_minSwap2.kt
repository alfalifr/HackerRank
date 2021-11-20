package interview_prep.arrays

import java.io.File


fun main() {
  minSwap2(arrayOf(7, 1, 3, 2, 4, 5, 6))
  minSwap2(arrayOf(4, 3, 1, 2))
  minSwap2(arrayOf(1, 3, 5, 2, 4, 6, 7))

  val file = File("_raw/interview_prep/minSwap2_input12.txt")
  val inn = file.inputStream().bufferedReader()
  inn.readLine()
  val arrStr = inn.readLine()

  val arr = arrStr.split(" ").map { it.toInt() }.toTypedArray()
  minSwap2(arr)
}

fun minSwap2(q: Array<Int>) {
  var swap = 0
  var min = Int.MAX_VALUE
  var minI = -1
  for(i in q.indices) {
    min = q[i]
    minI = -1
    if(min == i+1) {
      continue
    }
    //q.swap(q[i], q[q[i]])
    //swap++

    for(j in i+1 until q.size) {
      if(min > q[j]) {
        min = q[j]
        minI = j
      }
      if(min == i+1) {
        break
      }
    }
    if(minI >= 0) {
      q[i] += q[minI]
      q[minI] = q[i] - q[minI]
      q[i] -= q[minI]
      swap++
    }
  }
  //println("q = ${q.joinToString()}")
  println(swap)
}

fun Array<Int>.swap(i: Int, u: Int) {
  this[i] += this[u]
  this[u] = this[i] - this[u]
  this[i] -= this[u]
}