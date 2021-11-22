package interview_prep

//magrdrfgam


fun palindromeIndex(s: String): Int {
  // Write your code here
  if(s.length == 1 /*|| s.isPalindrome()*/) {
    return -1
  }

  val mid = s.length /2
  var j = s.length
  for(i in 0 until mid) {
    if(s[i] != s[--j]) {
      return when {
        s[i+1] == s[j] -> i
        s[i] == s[j-1] -> j
        else -> -100
      }
    }
  }
  return -1
}



fun String.isPalindrome(): Boolean {
  val mid = length /2
  var j = lastIndex
  for(i in 0 until mid) {
    if(this[i] != this[j--]) {
      return false
    }
  }
  return true
}