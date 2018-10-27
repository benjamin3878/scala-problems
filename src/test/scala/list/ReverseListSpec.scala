package list

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by vagrant on 17.10.18.
  */
class ReverseListSpec extends WordSpec with Matchers {

  "ReverseList" should {
    "return a empty list" in {
      ReverseList(List.empty[Int]) shouldBe List.empty[Int]
      ReverseList(List.empty[String]) shouldBe List.empty[String]
      ReverseList(List.empty[Double]) shouldBe List.empty[Double]
    }
    "release a list" in {
      val ints = List(1,2,3)
      ReverseList(ints) shouldBe ints.reverse

      val strs = List("1", "2", "3")
      ReverseList(strs) shouldBe strs.reverse
    }
  }

}
