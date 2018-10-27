package array

import org.scalatest.{Matchers, WordSpec}

class LargestAndSmallestInArraySpec extends WordSpec with Matchers {

  "LargestAndSmallestInArray" should {
    "return 1 from the List(1)" in {
      LargestAndSmallestInArray(List(1)) shouldBe (1,1)
    }
    "return (1,2) from Seq(1,2)" in {
      LargestAndSmallestInArray(Seq(1,2)) shouldBe (1,2)
    }
    "return (1,2) from Set(2,1)" in {
      LargestAndSmallestInArray(Set(2,1)) shouldBe (1,2)
    }
    "return the largest and smallest of a List" in {
      LargestAndSmallestInArray(List(2,1,3,4,0,5,7,1,7,9,4,10,1)) shouldBe (0,10)
    }
    "complex test" in {
      Range(0, 1000).foreach { _ =>
        val arr = Array.fill(100) {
          scala.util.Random.nextInt(1000)
        }
        val sortArr = arr.sorted
        val min = sortArr.head
        val max = sortArr.last

        LargestAndSmallestInArray(arr) shouldBe(min, max)
      }
    }
  }

}
