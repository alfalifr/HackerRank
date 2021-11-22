package interview_prep


fun miniMaxSum(arr: Array<Int>) {
  // Write your code here
  arr.sort()
  val list = arr.asList()
  val min = list.subList(0, list.lastIndex).fold(0L) { acc, i -> acc + i }
  val max = list.subList(1, list.size).fold(0L) { acc, i -> acc + i }

  println("$min $max")
}
