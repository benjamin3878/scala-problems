package array

import org.scalatest.{Matchers, WordSpec}

class BinarySearchSpec extends WordSpec with Matchers {

  "BinarySearch" should {
    "return None for an empty array" in {
      BinarySearch.indexOf(1, Array.empty[Int]) shouldBe None
      BinarySearch.indexOf("", Array.empty[String]) shouldBe None
      BinarySearch.indexOf(1L, Array.empty[Long]) shouldBe None
      BinarySearch.indexOf(1.0, Array.empty[Double]) shouldBe None
    }
    "return None when no match is found" in {
      BinarySearch.indexOf(1, Array(2)) shouldBe None
      BinarySearch.indexOf(1, Array(2,2,2)) shouldBe None
      BinarySearch.indexOf(1, Array.fill(100)(2)) shouldBe None
    }
    "return the current position" in {
      BinarySearch.indexOf(1, Array(1)) shouldBe Some(0)
      BinarySearch.indexOf(1, Array(2,1,2)) shouldBe Some(1)
      BinarySearch.indexOf(1, Array(1,2,3,4,5,6,7,8,9)) shouldBe Some(0)
      BinarySearch.indexOf(2, Array(1,2,3,4,5,6,7,8,9)) shouldBe Some(1)

      (0 to 100).foreach { i => BinarySearch.indexOf(i, (0 to 100).toArray) shouldBe Some(i) }
      (' ' to '~').foreach { c => BinarySearch.indexOf[Char](c, (' ' to '~').toArray) shouldBe Some(c.toInt - ' '.toInt) }
    }
  }

}
