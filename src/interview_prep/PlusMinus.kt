package interview_prep


fun plusMinus(arr: Array<Int>) {
  // Write your code here
  var positive = 0f
  var negative = 0f
  var zero = 0f

  for(e in arr) {
    when {
      e > 0 -> positive++
      e < 0 -> negative++
      else -> zero++
    }
  }
  println("%.6f".format(positive / arr.size))
  println("%.6f".format(negative / arr.size))
  println("%.6f".format(zero / arr.size))
}
