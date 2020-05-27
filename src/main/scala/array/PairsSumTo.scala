package array

import scala.collection.mutable
import scala.math.Ordering

/**
  * How do you find all pairs of an integer array whose sum is equal to a given number?
  */
object PairsSumTo {

  def apply(arr: Array[Int], k: Int): Set[(Int, Int)] = {
    val (sumOfPairs, _) = arr.foldLeft((Set.empty[(Int,Int)], Map.empty[Int,Int])) {
      case ((sumOfPairs, remainderToEle), next) if remainderToEle.contains(next) =>
        (sumOfPairs + (remainderToEle(next) -> next), remainderToEle)
      case ((sumOfPairs, remainderToEle), next) =>(sumOfPairs, remainderToEle + (k - next -> next))
    }

    sumOfPairs
  }


}
