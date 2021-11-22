package interview_prep


fun countingSort(arr: Array<Int>): Array<Int> {
  // Write your code here
  val counts = Array(100) { 0 }
  for(e in arr) {
    counts[e]++
  }
  return counts
}