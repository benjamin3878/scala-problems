package list

import scala.annotation.tailrec

/**
  * Merge to list in a alternating pattern (like shuffling cards)
  * List(1,3,5) + List(2,4,6) = List(1,2,3,4,5,6)
  */
object CardShuffle {

  def apply[A](left: List[A], right: List[A]): List[A] = {
    @tailrec
    def apply(cl: List[A], cr: List[A], acc: List[A]): List[A] = (cl, cr) match {
      case (Nil, Nil) => acc
      case (Nil, r) => acc ::: r
      case (l, Nil) => acc ::: l
      case (lHead::lTail, rHead::rTail) => apply(lTail, rTail, lHead :: rHead :: acc)
    }

    apply(left, right, List.empty[A])
  }
}
