package interview_prep

import util.IO

private const val fileName = "2_CountingValleys.txt"

fun main() {
  val steps = IO.InterviewPrep.readLine(fileName)!!.trim().toInt()

  val path = IO.InterviewPrep.readLine(fileName)!!.trimEnd()

  val res = countingValleys(steps, path)
  println(res)
}


fun countingValleys(steps: Int, path: String): Int {
  var alt = 0
  var valleys = 0
  for(step in path) {
    if(step == 'U') {
      if((alt + 1) == 0 && alt < 0) {
        valleys++
      }
      alt++
    } else {
      alt--
    }
  }
  return valleys
}
