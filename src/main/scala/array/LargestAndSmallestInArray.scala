package array

/**
  * How do you find the largest and smallest number in an unsorted integer array
  *
  * This implementation assumes at least one element.
  */
object LargestAndSmallestInArray {

  def apply[A](t: Traversable[A])(implicit ord: Ordering[A]): (A,A) = {
    t.drop(1).foldLeft((t.head, t.head)) {
      case ((smallest, largest), cur) =>
        (if (ord.compare(smallest, cur) < 0) smallest else cur,
          if (ord.compare(largest, cur) > 0) largest else cur)
    }
  }
}
