package array

import org.scalatest.{Matchers, WordSpec}

class RandomizeArrayInPlaceSpec extends WordSpec with Matchers {

  "randomizeArrayInPlace" should {
    "return an empty arr when given at empty" in {
      RandomizeArrayInPlace(Array.empty[Int]) shouldBe Array.empty[Int]
    }
    "return a single element array" in {
      val arr = Array("One")
      val result = RandomizeArrayInPlace(arr)

      result shouldBe Array("One")
      arr eq result shouldBe true
    }
    "return a randomized array" in {
      val length = 1000
      val arr = (0 until length).toArray
      val arrCopySinceItsInPlace = arr.clone()

      val result = RandomizeArrayInPlace(arr)

      result.length shouldBe length
      result eq arr shouldBe true
      result should not be arrCopySinceItsInPlace
      result.sorted shouldBe arrCopySinceItsInPlace
    }
  }

}
