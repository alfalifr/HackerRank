package interview_prep


fun findMedian(arr: Array<Int>): Int {
  // Write your code here
  arr.sort()
  return arr[arr.size/2]
}