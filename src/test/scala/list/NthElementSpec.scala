package list

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by vagrant on 18.10.18.
  */
class NthElementSpec extends WordSpec with Matchers {

  "NthElement" should {
    "return None for an empty list" in {
      NthElement.recursive(List.empty[Int], 0) shouldBe None
      NthElement.recursive(List.empty[Int], 1) shouldBe None
      NthElement.fold(List.empty[Int], 0) shouldBe None
      NthElement.fold(List.empty[Int], 1) shouldBe None
      NthElement.loop(List.empty[Int], 0) shouldBe None
      NthElement.loop(List.empty[Int], 1) shouldBe None
    }
    "return None for a number exceeding the length of the list" in {
      NthElement.recursive(List("1"), 5) shouldBe None
      NthElement.recursive(List("1", "2"), 5) shouldBe None
      NthElement.recursive(List("1", "2", "3"), 5) shouldBe None
      NthElement.recursive(List("1", "2", "3", "4"), 5) shouldBe None
      NthElement.fold(List("1"), 5) shouldBe None
      NthElement.fold(List("1", "2"), 5) shouldBe None
      NthElement.fold(List("1", "2", "3"), 5) shouldBe None
      NthElement.fold(List("1", "2", "3", "4"), 5) shouldBe None
      NthElement.loop(List("1"), 5) shouldBe None
      NthElement.loop(List("1", "2"), 5) shouldBe None
      NthElement.loop(List("1", "2", "3"), 5) shouldBe None
      NthElement.loop(List("1", "2", "3", "4"), 5) shouldBe None
    }
    "return the element at the Nth index" in {
      val list = List.fill(100)(scala.util.Random.nextInt())
      (0 until 100).foreach { i =>
        NthElement.recursive(list, i) shouldBe Some(list.toArray.apply(i))
        NthElement.fold(list, i) shouldBe Some(list.toArray.apply(i))
        NthElement.loop(list, i) shouldBe Some(list.toArray.apply(i))
      }
    }
  }

}
