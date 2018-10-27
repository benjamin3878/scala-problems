package array

import org.scalatest.{Matchers, WordSpec}

class MissingNumberSpec extends WordSpec with Matchers {

  "MissingNumber" should {
    "find the missing 2 in the array [1,3]" in {
      MissingNumber(Array(1,3)) shouldBe 2
    }
    "find the missing 2 in the array [3,1,4]" in {
      MissingNumber(Array(3,1,4)) shouldBe 2
    }
    "find the missing number in random array" in {
      Range(0, 100).foreach { _ =>
        val (arr, missingvalue) = randomArrayMissingOne()
        val result = MissingNumber(arr)
        try {
          result shouldBe missingvalue
        } catch {
          case t: Throwable => println(s"arr=$arr, missing value=$missingvalue"); throw t
        }
      }
    }
  }

  def randomArrayMissingOne(): (Array[Int], Int) = {
    val randomSortArr = RandomizeArrayInPlace((0 to 100).toArray)

    (randomSortArr.tail, randomSortArr.head)
  }

}
