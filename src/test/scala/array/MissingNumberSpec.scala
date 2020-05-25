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
        val (arr, missingValue) = randomArrayMissingOne()
        val result = MissingNumber(arr)
        try {
          result shouldBe missingValue
        } catch {
          case t: Throwable => println(s"arr=${arr.mkString(",")}, missing value=$missingValue"); throw t
        }
      }
    }
  }

  def randomArrayMissingOne(): (Array[Int], Int) = {
    // the element missing can't be the first or last
    val randomSortArr = RandomizeArrayInPlace((1 to 99).toArray)

    // randomize again the missing element is not always in the same place
    // add the first and last elements of the array
    // randomSortArr.head will be the missing element
    (0 +: RandomizeArrayInPlace(randomSortArr.tail) :+ 100, randomSortArr.head)
  }

}
