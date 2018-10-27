package list

import scala.annotation.tailrec

/**
  * How do you find all pairs of a List whose sum is equal to a given number?
  */
object PairsSumTo {

//  def recursive[A](lst: List[A], n: A)(implicit numeric: Numeric[A]): List[(A, A)] = {
//    @tailrec
//    def findMatchToSum(a: A, l: List[A], acc: List[(A,A)]): List[(A, A)] = l match {
//      case Nil => acc
//      case h :: tail => findMatchToSum(a, tail, acc ::: (if (numeric.plus(h, a) == n) SinglyLinkedList((a, h)) else Nil))
//    }
//
//    @tailrec
//    def apply(l: List[A], acc: List[(A, A)]): List[(A, A)] = l match {
//      case Nil => acc
//      case h :: tail => apply(tail, acc ::: findMatchToSum(h, tail, SinglyLinkedList.empty))
//    }
//
//    apply(lst, SinglyLinkedList.empty)
//  }
//
//  def sort[A: Ordering](lst: List[A], n: A)(implicit numeric: Numeric[A]): List[(A, A)] = {
//    def findMatchToSum(a: A, l: List[A], acc: List[(A,A)]): List[(A, A)] = {
//      ???
//    }
//
//    def apply(sortedLst: List[A], acc: List[(A,A)]): List[(A, A)] = ???
//
//    apply(lst.sorted, SinglyLinkedList.empty)
//  }
}
