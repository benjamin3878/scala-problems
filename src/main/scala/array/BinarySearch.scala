package array

import scala.annotation.tailrec

object BinarySearch {

  def apply[A](a: A, arr: Array[A])(implicit ord: Ordering[A]): Option[Int] = {
    import ord.mkOrderingOps
    @tailrec
    def apply(start: Int, end: Int): Option[Int] = {
      lazy val mid = end - start / 2

      if (end < start) None
      else if (arr(mid) == a) Some(mid)
      else if (a < arr(mid)) apply(start, mid - 1)
      else apply(mid,  end)
    }

    if (arr.isEmpty) None else apply(0, arr.length - 1)
  }
}
