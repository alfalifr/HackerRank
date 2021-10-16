package interview_prep.arrays


fun main() {
  rotLeft_test_gen(
    arr = arrayOf(1,2,3,4,5),
    expected = arrayOf(5,1,2,3,4),
    shift = 4,
  )
  rotLeft_test_gen(
    arr = arrayOf(1,2,3,4,5),
    expected = arrayOf(1,2,3,4,5),
    shift = 5,
  )
  rotLeft_test_gen(
    arr = arrayOf(1,2,3,4,5),
    expected = arrayOf(5,1,2,3,4),
    shift = 9,
  )
}


fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
  when(a.size) {
    1 -> return a
    d -> return a
  }
  val shift = d % a.size

  val newArr = a.copyOf()
  var i = a.size -1
  var u = i - shift

  while(u >= 0) {
    newArr[u--] = a[i--]
  }
  u = a.size -1
  while(i >= 0) {
    newArr[u--] = a[i--]
  }
  return newArr
}

fun rotLeft_test_gen(
  arr: Array<Int>,
  expected: Array<Int>,
  shift: Int,
) {
  val newArr = rotLeft(arr, shift)
  if(!newArr.contentEquals(expected)) {
    throw AssertionError("""
      
      expected = ${expected.joinToString()}
      actual = ${newArr.joinToString()}
    """.trimIndent()
    )
  }
  println("newArr = ${newArr.joinToString()}")
  println("arr = ${arr.joinToString()}")
}