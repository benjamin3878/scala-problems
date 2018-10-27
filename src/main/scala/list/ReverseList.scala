package list

import scala.annotation.tailrec

/**
  * How do you reverse a linked list
  */
object ReverseList {

  def apply[A](lst: List[A]): List[A] = {
    @tailrec
    def apply(l: List[A], acc: List[A]): List[A] = l match {
      case Nil => acc
      case head :: tail => apply(tail, head :: acc)
    }

    apply(lst, List.empty[A])
  }
}
