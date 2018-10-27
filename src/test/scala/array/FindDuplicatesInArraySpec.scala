package array

import org.scalatest.{Matchers, WordSpec}

class FindDuplicatesInArraySpec extends WordSpec with Matchers {

  "FindDuplicatesInArray" should {
    "return an empty set for an empty array" in {
      FindDuplicatesInArray(Array.empty[Int]) shouldBe Set.empty[Int]
    }
    "return an empty set for an array of one element" in {
      FindDuplicatesInArray(Array(1)) shouldBe Set.empty[Int]
      FindDuplicatesInArray(Array("1")) shouldBe Set.empty[String]
      FindDuplicatesInArray(Array(1.0)) shouldBe Set.empty[Double]
      FindDuplicatesInArray(Array(1L)) shouldBe Set.empty[Long]
    }
    "find the one duplicate" in {
      val arr = Array(1, 1)
      val set = Set(1)
      FindDuplicatesInArray(arr) shouldBe set
      FindDuplicatesInArray(arr.map(_.toString)) shouldBe set.map(_.toString)
      FindDuplicatesInArray(arr.map(_.toDouble)) shouldBe set.map(_.toDouble)
      FindDuplicatesInArray(arr.map(_.toLong)) shouldBe set.map(_.toLong)

      val arr2 = Array(2, 1, 1)

      FindDuplicatesInArray(arr2) shouldBe set
      FindDuplicatesInArray(arr2.map(_.toString)) shouldBe set.map(_.toString)
      FindDuplicatesInArray(arr2.map(_.toDouble)) shouldBe set.map(_.toDouble)
      FindDuplicatesInArray(arr2.map(_.toLong)) shouldBe set.map(_.toLong)
    }
    "find all of the duplicates" in {
      val arr = Array(2, 1, 1, 3, 4, 4, 5)
      val set = Set(1,4)
      FindDuplicatesInArray(arr) shouldBe set
      FindDuplicatesInArray(arr.map(_.toString)) shouldBe set.map(_.toString)
      FindDuplicatesInArray(arr.map(_.toDouble)) shouldBe set.map(_.toDouble)
      FindDuplicatesInArray(arr.map(_.toLong)) shouldBe set.map(_.toLong)
    }
  }

}
