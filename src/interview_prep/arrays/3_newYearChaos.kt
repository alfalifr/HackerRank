package interview_prep.arrays

import kotlin.math.max


fun main() {
  minimumBribes3(arrayOf(2, 1, 5, 3, 4)) //3
  minimumBribes3(arrayOf(2, 5, 1, 3, 4)) //too chaotic
  minimumBribes3(arrayOf(1, 2, 5, 3, 7, 8, 6, 4)) //7
  minimumBribes3(arrayOf(3, 4, 2, 1, 6, 5, 9, 7, 10, 12, 8, 13, 11, 14, 15)) //12
  minimumBribes3("1 2 3 4 5 8 6 10 11 7 13 9 14 12 15".split(" ").map { it.toInt() }.toTypedArray()) //9
  minimumBribes3("1 2 3 4 5 8 6 10 7 11 13 9 14 12 15".split(" ").map { it.toInt() }.toTypedArray()) //9
  println("=========")
  minBribes4(arrayOf(2, 1, 5, 3, 4)) //3
  minBribes4(arrayOf(2, 5, 1, 3, 4)) //too chaotic
  minBribes4(arrayOf(1, 2, 5, 3, 7, 8, 6, 4)) //7
  minBribes4(arrayOf(3, 4, 2, 1, 6, 5, 9, 7, 10, 12, 8, 13, 11, 14, 15)) //12
  minBribes4("1 2 3 4 5 8 6 10 11 7 13 9 14 12 15".split(" ").map { it.toInt() }.toTypedArray()) //9
  minBribes4("1 2 3 4 5 8 6 10 7 11 13 9 14 12 15".split(" ").map { it.toInt() }.toTypedArray()) //9

//1 2 5 3 7 8 6 4 -> 7
//1 2 3 4 5 6 7 8

//  1 2 3 4 5 8 6 10 11 7  13 9  14 12 15 -> 9
//  1 2 3 4 5 6 7 8  9  10 11 12 13 14 15


//  3 4 2 1 6 5 9 7 10 12 8  13 11 14 15 -> 12
//  1 2 3 4 5 6 7 8  9 10 11 12 13 14 15


//1 2 3 4 5 7 6 8,
//0 1 2 3 4 5 6 7

//1 2 5 3 7 8 6 4, -> 7
//1 2 3 4 5 6 7 8
//0 1 2 3 4 5 6 7

//1 2 3 4 7 5 8 6
//1 2 3 4 5 6 7 8
//0 1 2 3 4 5 6 7
}
fun minBribes4(q: Array<Int>) {
  var bribes = 0
  for(i in q.indices) {
    if(q[i] > i+3) {
      println("Too chaotic")
      return
    }
    //q[i] -2 means that anyone who bribes q[i] can't forth more than 1 position in front of q[i] original position.
    // Actually, we can check from 0 (all in front of q[i]), but it will waste time because we know the above statement.
    for(j in max(0, q[i] -2) until i) {
      if(q[j] > q[i]) bribes++
    }
  }
  println(bribes)
}
fun minimumBribes3(q: Array<Int>) {
  var bribes = 0

  for(i in 0 until q.lastIndex) {
    when {
      q[i] > i+3 -> {
        println("Too chaotic")
        return
      }
      q[i] > i+1 -> bribes += q[i] - (i+1)
      q[i] < i+1 -> {
        if(q[i] > q[i+1]) {
          bribes++
        }
      }
    }
  }
  println(bribes)
}

/*
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
 */
