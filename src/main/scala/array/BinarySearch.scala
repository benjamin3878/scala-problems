package array

import scala.annotation.tailrec

object BinarySearch {

  def indexOf[A](a: A, arr: Array[A])(implicit ord: Ordering[A]): Option[Int] = {
    @tailrec
    def indexOf(start: Int, end: Int): Option[Int] = {
      lazy val mid = end - start / 2

      if (end < start) None
      else if (arr(mid) == a) Some(mid)
      else if (ord.compare(a, arr(end - start)) < 0) indexOf(start, mid - 1)
      else indexOf(mid,  end)
    }

    if (arr.isEmpty) None else indexOf(0, arr.length - 1)
  }
}
