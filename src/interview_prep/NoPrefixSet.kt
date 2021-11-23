package interview_prep

import kotlin.math.min

fun main() {
  java.lang.String()
  noPrefix(arrayOf(
    "aab", "defgab", "abcde", "aabcde", "bbbbbbbbbb", "jabjjjad",
  ))
  noPrefix(arrayOf("ab","bc","cd"))
  noPrefix(arrayOf("aab", "aac", "aacghgh", "aabghgh"))
}

//TODO: Still timeout for case 37-41
fun noPrefix(words: Array<String>) {
  // Write your code here
  //val checkedPrefixIndices = mutableListOf<Int>()
  var minPrefixIndex = words.size
  for(i in words.indices) {
    if(i >= minPrefixIndex) {
      break
    }
    u@ for(u in i+1 until words.size) {
      //val longIndex: Int
      val short: String
      val long = if(words[i].length >= words[u].length) {
        //longIndex = i
        short = words[u]
        words[i]
      } else {
        /*
        if(words[i].length == words[u].length && words[i] == words[u]) {
          minPrefixIndex = u
          continue@u
        }
         */
        //longIndex = u
        short = words[i]
        words[u]
      }
      for(j in short.indices) {
        if(short[j] != long[j]) {
          continue@u
        }
      }
      /*
      println("BAD SET")
      println(long)
      return
       */
      if(minPrefixIndex > u) {
        minPrefixIndex = u
        break
      }
    }
  }
  if(minPrefixIndex < words.size) {
    println("BAD SET")
    println(words[minPrefixIndex])
  } else {
    println("GOOD SET")
  }
}