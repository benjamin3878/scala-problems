package list

/**
  * How do you reverse a singly linked list without recursion?
  */
object ReverseWithOutRecursion {

  def apply[A](lst: List[A]): List[A] = {
    var reveredList: List[A] = Nil
    var cur = lst

    while (cur != Nil) {
      cur match { case head :: tail => reveredList = head :: reveredList; cur = tail }
    }

    reveredList
  }

  def foldReverse[A](lst: List[A]): List[A] = lst.foldLeft(List.empty[A]) { case (acc, next) => next :: acc }



}
