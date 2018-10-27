package list

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by vagrant on 18.10.18.
  */
class ReverseWithOutRecursionSpec extends WordSpec with Matchers {

  "ReverseWithOutRecursion" should {
    "reverse a empty list" in {
      ReverseWithOutRecursion(List.empty[String]) shouldBe List.empty[String]
      ReverseWithOutRecursion(List.empty[Int]) shouldBe List.empty[Int]
      ReverseWithOutRecursion.foldReverse(List.empty[String]) shouldBe List.empty[String]
      ReverseWithOutRecursion.foldReverse(List.empty[Int]) shouldBe List.empty[Int]
    }
    "reverse a single element list" in {
      val singleElement = List("a")
      ReverseWithOutRecursion(singleElement) shouldBe singleElement
      ReverseWithOutRecursion.foldReverse(singleElement) shouldBe singleElement
    }
    "reverse a two element list" in {
      val twoElemenets = List(1,2)
      ReverseWithOutRecursion(twoElemenets) shouldBe twoElemenets.reverse
      ReverseWithOutRecursion.foldReverse(twoElemenets) shouldBe twoElemenets.reverse
    }
    "reverse a random 100 element list" in {
      (0 to 100).foreach { i =>
        val randomList = List.fill(100)(math.random())

        ReverseWithOutRecursion(randomList) shouldBe randomList.reverse
        ReverseWithOutRecursion.foldReverse(randomList) shouldBe randomList.reverse
      }
    }
  }

}
