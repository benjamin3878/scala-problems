package array

import scala.math.Ordering

/**
  * How do you find the duplicates a given array?
  */
object FindDuplicatesInArray {

  def apply[A: Ordering](arr: Array[A]): Set[A] = {
    if (arr.isEmpty) { Set.empty }
    else {
      val sortedArr = arr.sorted
      sortedArr.drop(1).foldLeft((Set.empty[A], sortedArr.head)) {
        case ((dups, last), cur) if cur == last =>  dups + cur -> last
        case ((dups, _), cur) => dups -> cur
      }._1
    }
  }
}
