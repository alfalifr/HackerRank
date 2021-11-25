package interview_prep

import kotlin.math.max
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

  fun isPrefix(str1: String, str2: String): Boolean {
    val shortLen = min(str1.length, str2.length)
    val mid = shortLen /2
    for(j in 0 until mid) {
      if(str1[j] != str2[j]
        || str1[shortLen-j-1] != str2[shortLen-j-1]) {
        return true
      }
    }
    if(str1[mid] != str2[mid]) {
      return true
    }
    return false
  }

  /**
   * Returns the index of prefixes
   */
  fun randomSearch(
    min: Int = 0,
    max: Int = words.size,
    limit: Int = 30,
  ): Int {
    var i = 0
    val visitedIndex = mutableSetOf<Pair<Int, Int>>()
    var foundIndex = -1
    val usedMax = min(max, words.size) -1
    do {
      val index1 = (Math.random() * usedMax).toInt() +min
      var index2 = (Math.random() * usedMax).toInt() +min
      if(visitedIndex.any { it.first == index1 && it.second == index2 }) {
        continue
      }
      while(index2 == index1) {
        index2 = (Math.random() * words.lastIndex).toInt()
      }
      if(isPrefix(words[index1], words[index2])) {
        foundIndex = min(index1, index2)
        break
      }
      visitedIndex += index1 to index2
      i++
    } while(i < limit)
    return foundIndex
  }

  fun linearSearch(start: Int, end: Int) {
    for(i in start until end) {
      if(i >= minPrefixIndex) {
        break
      }
      u@ for(u in i+1 until words.size) {
        //val longIndex: Int
        //val shortLen = min(words[i].length, words[u].length)
        /*
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
         */
        // 0 1
        // 0 1 2 3
        if(isPrefix(words[i], words[u])) {
          continue@u
        }
        /*
        val mid = shortLen /2
        for(j in 0 until mid) {
          if(words[i][j] != words[u][j]
            || words[i][shortLen-j-1] != words[u][shortLen-j-1]) {
            continue@u
          }
        }
        if(words[i][mid] != words[u][mid]) {
          continue@u
        }
         */
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
  }

  if(words.size < 50_000) {
    linearSearch(0, words.size)
  } else {
    val offset = words.size /10

    var limitIndex = -1
    var randomItr = words.size / 10_000
    while(randomItr-- > 0) {
      val limitIndexItr = randomSearch(
        offset, offset, 30
      )
      if(limitIndex > limitIndexItr || limitIndex == -1) {
        limitIndex = limitIndexItr
      }
    }
    linearSearch(offset, if(limitIndex >= 0) limitIndex else words.size)
  }

  if(minPrefixIndex < words.size) {
    println("BAD SET")
    println(words[minPrefixIndex])
  } else {
    println("GOOD SET")
  }
}