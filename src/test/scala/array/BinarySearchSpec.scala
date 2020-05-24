package array

import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class BinarySearchSpec extends WordSpec with Matchers {

  "BinarySearch" should {
    "return None for an empty array" in {
      BinarySearch(1, Array.empty[Int]) shouldBe None
      BinarySearch("", Array.empty[String]) shouldBe None
      BinarySearch(1L, Array.empty[Long]) shouldBe None
      BinarySearch(1.0, Array.empty[Double]) shouldBe None
    }
    "return None when no match is found" in {
      BinarySearch(1, Array(2)) shouldBe None
      BinarySearch(1, Array(2,2,2)) shouldBe None
      BinarySearch(1, Array.fill(100)(2)) shouldBe None
    }
    "return the current position" in {
      BinarySearch(1, Array(1)) shouldBe Some(0)
      BinarySearch(1, Array(2,1,2)) shouldBe Some(1)
      BinarySearch(1, Array(1,2,3,4,5,6,7,8,9)) shouldBe Some(0)
      BinarySearch(2, Array(1,2,3,4,5,6,7,8,9)) shouldBe Some(1)
      BinarySearch(8, Array(1,2,3,4,5,6,7,8,9)) shouldBe Some(7)

      (0 to 100).foreach { i => BinarySearch(i, (0 to 100).toArray) shouldBe Some(i) }
      (' ' to '~').foreach { c => BinarySearch[Char](c, (' ' to '~').toArray) shouldBe Some(c.toInt - ' '.toInt) }
    }
    "dynamic test" in {
      val arr = List.fill(100)(Random.nextInt()).sorted.distinct.toArray
      arr.view.zipWithIndex.foreach { case (ele, index) => BinarySearch(ele, arr) shouldBe Some(index) }
    }
  }

}
