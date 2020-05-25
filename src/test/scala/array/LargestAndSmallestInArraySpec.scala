package array

import org.scalatest.{Matchers, WordSpec}

class LargestAndSmallestInArraySpec extends WordSpec with Matchers {

  def allLargestAndSmallestInArrayAlgorithms[A: Ordering]: List[Iterable[A] => (A,A)] = List(
    LargestAndSmallestInArray.apply[A],
    LargestAndSmallestInArray.scalaStyle[A]
  )

  "LargestAndSmallestInArray" should {
    "return 1 from the List(1)" in {
      allLargestAndSmallestInArrayAlgorithms[Int].foreach(_.apply(List(1)) shouldBe (1,1))
    }
    "return (1,2) from Seq(1,2)" in {
      allLargestAndSmallestInArrayAlgorithms[Int].foreach(_.apply(Seq(1,2)) shouldBe (1,2))
    }
    "return (1,2) from Set(2,1)" in {
      allLargestAndSmallestInArrayAlgorithms[Int].foreach(_.apply(Set(2,1)) shouldBe (1,2))
    }
    "return the largest and smallest of a List" in {
      allLargestAndSmallestInArrayAlgorithms[Int].foreach(_.apply(List(2,1,3,4,0,5,7,1,7,9,4,10,1)) shouldBe (0,10))
    }
    "complex test" in {
      Range(0, 1000).foreach { _ =>
        val arr = Array.fill(100) {
          scala.util.Random.nextInt(1000)
        }
        val sortArr = arr.sorted
        val min = sortArr.head
        val max = sortArr.last

        allLargestAndSmallestInArrayAlgorithms[Int].foreach(_.apply(arr) shouldBe(min, max))
      }
    }
  }

}
