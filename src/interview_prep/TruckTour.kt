package interview_prep


fun main() {
  val res = truckTour(
    arrayOf(
      arrayOf(1,5),
      arrayOf(10,3),
      arrayOf(3,4),
    )
  )
  println(res)
}

fun truckTour(petrolpumps: Array<Array<Int>>): Int {
  // Write your code here
  //println("petrolpumps.size = ${petrolpumps.size}")
  //println("petrolpumps = ${petrolpumps.joinToString { it.joinToString(prefix = "[", postfix = "]") }}")
  if(petrolpumps.size == 1) {
    return 0
  }

  val diffs = petrolpumps.map { it[0] - it[1] } //.iterator()
  i@ for(i in diffs.indices) {
    var sum = 0
    for(u in diffs.indices) {
      sum += diffs[(u + i) % diffs.size]
      if(sum < 0) {
        continue@i
      }
    }
    return i
  }

  return 0
  /*
  var largestDiff = diffs.next()
  var i = 0
  var start = i
  for(diff in diffs) {
    //println("diff = $diff largestDiff = $largestDiff")
    i++
    if(largestDiff < diff) {
      largestDiff = diff
      start = i
    }
  }
  //println(start)
  return start
   */
}