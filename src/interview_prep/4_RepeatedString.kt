package interview_prep

import util.IO

private const val fileName = "4_RepeatedString.txt"

fun main() {
  val str = IO.InterviewPrep.readLine(fileName)!!.trim()

  val repeat = IO.InterviewPrep.readLine(fileName)!!.trim().toLong()

  val res = repeatedString(str, repeat)
  println(res)
}


fun repeatedString(s: String, n: Long): Long {
  if(s == "a") return n
  if(s.length == 1 && s != "a") return 0

  var aInS = 0
  for(c in s) {
    if(c == 'a') aInS++
  }
  val wordDiv = n / s.length
  val wordRem = (n % s.length).toInt()
  var aSum = wordDiv * aInS

  if(wordRem > 0) {
    for(i in 0 until wordRem) {
      if(s[i] == 'a') aSum++
    }
  }
  return aSum
}
