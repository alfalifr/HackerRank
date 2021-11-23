package data_structures

fun main() {
  matchingStrings(
    arrayOf("ab","ab","abc",),
    arrayOf("ab","abc","bc",),
  )
}

fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
  // Write your code here
  val counts = Array(queries.size) { 0 }
  val isRemoved = BooleanArray(strings.size)

  i@ for(i in queries.indices) {
    for(u in strings.indices) {
      if(isRemoved[u]) {
        if(queries[i] == strings[u]) {
          val query = queries[i]
          for(j in 0 until i) {
            if(queries[j] == query) {
              counts[i] = counts[j]
              continue@i
            }
          }
        }
        continue
      }
      if(queries[i] == strings[u]) {
        counts[i]++
        isRemoved[u] = true
      }
    }
  }

  println("counts = ${counts.joinToString()}")
  return counts
}