package list

import scala.annotation.tailrec

/**
  * How do you find the length of a singly linked list?
  */
object Length {

  def recursive[A](list: List[A]): Int = {
    @tailrec
    def apply(cur: List[A], acc: Int): Int = cur match {
      case Nil => acc
      case _ :: tail => apply(tail, acc + 1)
    }

    apply(list, 0)
  }

  def fold[A](list: List[A]): Int = list.foldLeft(0)((acc, _) => acc + 1)

  def loop[A](list: List[A]): Int = {
    var count = 0
    var cur: List[A] = list
    while(cur != Nil) {
      cur match { case _ :: tail => count = count + 1; cur = tail }
    }

    count
  }
}
