package array

import scala.collection.mutable
import scala.math.Ordering

/**
 * How do you find the duplicates in a given array?
 */
object FindDuplicatesInArray {

  /*
   * O(n^2) compute
   * O(1) memory
   */
  def computationallyExpensive[A](arr: Array[A]): Set[A] =
    (for {
      (ele, i) <- arr.view.zipWithIndex
      next <- (i + 1 until arr.length).map(arr)
      if (ele == next)
    } yield { next }).toSet

  def memoryExpensive[A](arr: Array[A]): Set[A] = {
    val map = mutable.Map.empty[A, Int]

    arr.foreach {
      case ele if map.contains(ele) => map += ele -> (map(ele) + 1)
      case ele => map += (ele -> 1)
    }

    map.filter(_._2 > 1).keys.toSet
  }

  def sortAndCompareLast[A: Ordering](arr: Array[A]): Set[A] =
    arr.sorted.foldLeft((Set.empty[A], Option.empty[A])) {
      case ((acc, None), next) => (acc, Some(next))
      case ((acc, Some(last)), next) if last == next => (acc + next, Some(next))
      case ((acc, _), next) => (acc, Some(next))
    }._1

  def scalaStyle[A](arr: Array[A]): Set[A] = arr.groupBy(identity).collect { case (ele, ls) if ls.length > 1 => ele }.toSet
}
