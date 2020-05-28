package list

import scala.annotation.tailrec

/**
  * How do you find the Nth element in a singly linked list?
  * zero indexed.
  */
object NthElement {

  def recursive[A](list: List[A], Nth: Int): Option[A] = {
    @tailrec
    def apply(cur: List[A], acc: Option[A], count: Int): Option[A] = cur match {
      case Nil => acc
      case head :: _ if count == Nth => Some(head)
      case _ :: tail => apply(tail, acc, count + 1)
    }

    apply(list, None, 0)
  }

  def fold[A](list: List[A], Nth: Int): Option[A] = list.foldLeft[(Int, Option[A])]((0, None)) {
    case ((count, o), next) => if (count == Nth) return Some(next) else (count + 1, o)
  }._2

  def loop[A](list: List[A], Nth: Int): Option[A] = {
    var cur: List[A] = list
    var count = 0
    var ele: Option[A] = None
    while(cur != Nil && count <= Nth && ele.isEmpty) {
      cur match { case head :: tail => if (count == Nth) ele = Some(head) else count += 1; cur = tail }
    }

    ele
  }
}
