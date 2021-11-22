package interview_prep


fun caesarCipher(s: String, k: Int): String {
  // Write your code here
  val charArr = s.toCharArray()
  for(i in charArr.indices) {
    val c = charArr[i]
    if(c.isLetter()) {
      var cInt = if(c.isLowerCase()) c - 'a' else c - 'A'
      cInt = (cInt + k) % 26
      val newC = (cInt + (if(c.isLowerCase()) 'a' else 'A').toInt()).toChar()
      charArr[i] = newC
    }
  }
  return String(charArr)
}
