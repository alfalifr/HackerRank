package interview_prep

fun main() {
  println(isBalanced("(){}"))
  println(isBalanced("(){"))
  println(isBalanced(")("))
  println(isBalanced("({[]})"))
  println(isBalanced("({)}"))
}

fun isBalanced(s: String): String {
  // Write your code here

  val bracketScope = 0
  val squareScope = 1
  val curlyScope = 2

  var bracket = 0
  var square = 0
  var curly = 0

  //0 for '(', 1 for '[', 2 for '{'
  var scope = -1

  for(c in s) {
    when(c) {
      '(' -> {
        bracket++
        scope = bracketScope
      }
      '[' -> {
        square++
        scope = squareScope
      }
      '{' -> {
        curly++
        scope = curlyScope
      }
      ')' -> {
        if (bracket-- == 0 ||
          (scope != bracketScope && scope > -1)
        ) {
          return "NO"
        }
        scope = -1
      }
      ']' -> {
        if(square-- == 0 ||
          (scope != squareScope && scope > -1)
        ) {
          return "NO"
        }
        scope = -1
      }
      '}' -> {
        if(curly-- == 0 ||
          (scope != curlyScope && scope > -1)
        ) {
          return "NO"
        }
        scope = -1
      }
    }
  }
  return if(bracket == 0 && square == 0 && curly == 0) "YES"
  else "NO"
}
