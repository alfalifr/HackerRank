package interview_prep.arrays


fun main() {
  minimumBribes(arrayOf(2, 1, 5, 3, 4))
  minimumBribes(arrayOf(2, 5, 1, 3, 4))
  minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
}


fun minimumBribes2(q: Array<Int>) {
  val chaoticStr = "Too chaotic"

  if(q.size <= 1) {
    println(0)
    return
  }

  var prev = q[0]
  if(prev - 1 > 2) {
    println(chaoticStr)
  }
  var bribes = prev - 1
  var lastNormal = 1
  var diff = 0

  var isNormal = bribes == 0

  for(i in 1 until q.lastIndex) {
    if(q[i] - prev == 1) {
      if(!isNormal) {
        bribes +=
      }
    }
  }

}

fun minimumBribes(q: Array<Int>) {
  // Write your code here
  var bribes = 0
  val allowedRange = 1..2
  var shift = 0
  var shadow = 0
  println("q = ${q.joinToString()}")

  for((i, person) in q.withIndex()) {
    val absoluteDiff = person - i - 1 //+ shift //+ shadow--
    var diff = absoluteDiff
    if(shadow > 0) { diff += shift + shadow }
    shadow--
    println("i = $i person = $person absoluteDiff = $absoluteDiff shift= $shift shadow = $shadow diff = $diff")
    //diff = absoluteDiff
    when {
      diff in allowedRange -> {
        bribes += diff
        shift++
        shadow = diff
      }
      diff >= 3 -> {
        println("Too chaotic")
        return
      }
    }
  }
  println(bribes)
}