package array

/**
  * How do you find the largest and smallest number in an unsorted collection
  *
  * This implementation assumes at least one element.
  */
object LargestAndSmallestInArray {

  def apply[A](iterable: Iterable[A])(implicit ord: Ordering[A]): (A,A) = {
    if (iterable.isEmpty) throw new UnsupportedOperationException("empty.min")

    import ord.mkOrderingOps
    iterable.drop(1).foldLeft((iterable.head, iterable.head)) {
      case ((smallest, largest), cur) => (if (smallest < cur) smallest else cur, if (largest > cur) largest else cur)
    }
  }

  def scalaStyle[A: Ordering](iterable: Iterable[A]): (A,A) = (iterable.min, iterable.max)
}
