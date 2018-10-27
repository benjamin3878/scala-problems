package array

/**
  * How do you find the missing number in a given integer array of 1 to 100?
  *
  * This implementation assumes valid data.
  */
object MissingNumber {

  def apply(start: Int, end: Int)(array: Array[Int]): Int = {
    val betweenStartandEnd: Int => Boolean = i => i >= start && i <= end
    val expected = Σ(end) - Σ(start)
    val sumBetween = array.fold(0){ case (acc, next) => if (betweenStartandEnd(next)) acc + next else acc }

    expected - sumBetween
  }

  def apply(end: Int)(array: Array[Int]): Int = apply(0, end)(array)
  def apply(array: Array[Int]): Int = apply(0, array.length)(array)

  private def Σ(n: Int): Int = n * (n + 1) / 2
}
