package array

/**
  * How do you find the missing number in a given integer array of m to n?
  * {m ∣ m∈Z, 0<m }
  * {n ∣ n∈Z, m<n }
  * There are at least 2 elements in the array.
  * This implementation assumes valid data.
  */
object MissingNumber {

  def apply(end: Int)(array: Array[Int]): Int = MissingNumber(0, end)(array)
  def apply(start: Int, end: Int)(array: Array[Int]): Int = MissingNumber(array.slice(start, end))

  def apply(array: Array[Int]): Int = {
    def Σ(n: Int): Int = n * (n + 1) / 2

    Σ(array.max) - Σ(array.min - 1) - array.sum
  }
}
