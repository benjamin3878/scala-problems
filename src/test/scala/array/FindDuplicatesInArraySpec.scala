package array

import org.scalatest.WordSpec
import org.scalatest.matchers.should.Matchers

import scala.math.Ordering

class FindDuplicatesInArraySpec extends WordSpec with Matchers {

  def allFindDuplicatesInArrayMethod[A: Ordering]: List[Array[A] => Set[A]] = List(
    FindDuplicatesInArray.computationallyExpensive[A],
    FindDuplicatesInArray.memoryExpensive[A],
    FindDuplicatesInArray.sortAndCompareLast[A],
    FindDuplicatesInArray.scalaStyle[A]
  )

  "FindDuplicatesInArray" should {
    "return an empty set for an empty array" in {
      allFindDuplicatesInArrayMethod[Int].foreach(_.apply(Array.empty[Int]) shouldBe Set.empty[Int])
    }
    "return an empty set for an array of one element" in {
      allFindDuplicatesInArrayMethod[Int].foreach(_.apply(Array(1)) shouldBe Set.empty[Int])
      allFindDuplicatesInArrayMethod[String].foreach(_.apply(Array("1")) shouldBe Set.empty[String])
      allFindDuplicatesInArrayMethod[Double].foreach(_.apply(Array(1.0)) shouldBe Set.empty[Double])
      allFindDuplicatesInArrayMethod[Long].foreach(_.apply(Array(1L)) shouldBe Set.empty[Long])
    }
    "find the one duplicate" in {
      val arr = Array(1, 1)
      val set = Set(1)
      allFindDuplicatesInArrayMethod[Int].foreach(_.apply(arr) shouldBe set)
      allFindDuplicatesInArrayMethod[String].foreach(_.apply(arr.map(_.toString)) shouldBe set.map(_.toString))
      allFindDuplicatesInArrayMethod[Double].foreach(_.apply(arr.map(_.toDouble)) shouldBe set.map(_.toDouble))
      allFindDuplicatesInArrayMethod[Long].foreach(_.apply(arr.map(_.toLong)) shouldBe set.map(_.toLong))

      val arr2 = Array(2, 1, 1)

      allFindDuplicatesInArrayMethod[Int].foreach(_.apply(arr2) shouldBe set)
      allFindDuplicatesInArrayMethod[String].foreach(_.apply(arr2.map(_.toString)) shouldBe set.map(_.toString))
      allFindDuplicatesInArrayMethod[Double].foreach(_.apply(arr2.map(_.toDouble)) shouldBe set.map(_.toDouble))
      allFindDuplicatesInArrayMethod[Long].foreach(_.apply(arr2.map(_.toLong)) shouldBe set.map(_.toLong))
    }
    "find all of the duplicates" in {
      val arr = Array(2, 1, 1, 3, 4, 4, 5)
      val set = Set(1,4)
      allFindDuplicatesInArrayMethod[Int].foreach(_.apply(arr) shouldBe set)
      allFindDuplicatesInArrayMethod[String].foreach(_.apply(arr.map(_.toString)) shouldBe set.map(_.toString))
      allFindDuplicatesInArrayMethod[Double].foreach(_.apply(arr.map(_.toDouble)) shouldBe set.map(_.toDouble))
      allFindDuplicatesInArrayMethod[Long].foreach(_.apply(arr.map(_.toLong)) shouldBe set.map(_.toLong))
    }
  }

}
