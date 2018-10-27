package list

/**
  * Created by vagrant on 17.10.18.
  */
object SinglyLinkedList {

  def apply[A](a: A*): SinglyLinkedList[A] = a.foldLeft[SinglyLinkedList[A]](Nil) { case (acc, ele) => Node(ele, acc) }

  sealed trait SinglyLinkedList[+A]
  case class Node[+A](a: A, nxt: SinglyLinkedList[A]) extends SinglyLinkedList[A]
  case object Nil extends SinglyLinkedList[Nothing]

}
