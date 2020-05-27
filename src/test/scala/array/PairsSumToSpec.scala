package array

import org.scalatest.{Matchers, WordSpec}

class PairsSumToSpec extends WordSpec with Matchers {

  "PairsSumTo" should {
    "return empty for empty input" in {
      PairsSumTo(Array.emptyIntArray, 1) shouldBe Set.empty[(Int, Int)]
    }
    "return empty for no matches" in {
      PairsSumTo(Array(1,2,3,4,5,6,7,8,9), 18) shouldBe Set.empty[(Int, Int)]
    }
    "return all matches" in {
      PairsSumTo(Array(1,1), 2) shouldBe Set((1,1))
      PairsSumTo(Array(1,2,1), 2) shouldBe Set((1,1))
      PairsSumTo(Array(2,1,2,1), 2) shouldBe Set((1,1))

      PairsSumTo(Array(2,1,8,9), 10) shouldBe Set((2,8), (1,9))
      PairsSumTo(Array(2,1,8,9).reverse, 10) shouldBe Set((8,2), (9,1)) // stable

      PairsSumTo(Array(0,2,0,1,0,8,0,9,0), 10) shouldBe Set((2,8), (1,9))
    }
  }
}
