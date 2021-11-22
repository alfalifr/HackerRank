package interview_prep


fun timeConversion(s: String): String {
  // Write your code here
  var hour = s.substring(0, 2).toInt()
  when(s.substring(s.lastIndex-1)) {
    "AM" -> {
      if(hour == 12) {
        hour = 0
      }
    }
    "PM" -> {
      if(hour < 12) {
        hour += 12
      }
    }
  }
  return "${if(hour >= 10) hour else "0$hour"}${s.substring(2, s.lastIndex-1)}"
}