package interview_prep

fun lonelyinteger(a: Array<Int>): Int {
  // Write your code here
  if(a.size == 1) {
    return a[0]
  }
  val counts = IntArray(101)
  for(e in a) {
    counts[e]++
  }
  return counts.indexOfFirst { it == 1 }
}