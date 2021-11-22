package interview_prep


fun towerBreakers(n: Int, m: Int): Int {
  // Write your code here
  return if(n % 2 == 0 || m == 1) 2
  else 1
}
