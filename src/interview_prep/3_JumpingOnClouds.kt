package interview_prep

import util.IO

private const val fileName = "3_JumpingOnClouds.txt"

fun main() {
  val n = IO.InterviewPrep.readLine(fileName)!!.trim().toInt()

  val clouds = IO.InterviewPrep.readIntArray(fileName)!!

  val res = jumpingOnClouds(clouds)
  println(res)
}


fun jumpingOnClouds(c: Array<Int>): Int {
  // Write your code here
  var i = 0
  var step = 0
  while(true) {
    if(i >= c.size -1) break
    else if(i < c.size -2 && c[i+2] == 0) i += 2
    else i++
    step++
  }
  return step
}
