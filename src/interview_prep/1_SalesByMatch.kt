package interview_prep

import util.IO

fun main() {
  val n = IO.InterviewPrep.readLine("1_SalesByMatch.txt")!!.trim().toInt()

  val ar = IO.InterviewPrep.readLine("1_SalesByMatch.txt")!!.trimEnd()
    .split(" ").map { it.toInt() }.toTypedArray()

  val res = sockMerchant(n, ar)
  println(res)
}


fun sockMerchant(n: Int, ar: Array<Int>): Int {
  val map = mutableMapOf<Int, Int>()
  for(i in ar) {
    map[i] = map[i]?.plus(1) ?: 1
  }

  if(map.keys.size == ar.size) return 0

  var sum = 0
  for(v in map.values) {
    sum += v / 2
  }

  return sum
}