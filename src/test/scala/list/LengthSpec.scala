package list

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by vagrant on 18.10.18.
  */
class LengthSpec extends WordSpec with Matchers {

  "Length" should {
    "return zero for an empty list" in {
      Length.recursive(List.empty[String]) shouldBe 0
      Length.fold(List.empty[String]) shouldBe 0
      Length.loop(List.empty[String]) shouldBe 0
    }
    "return 1 for a single element list" in {
      val lst = List("1")
      Length.recursive(lst) shouldBe 1
      Length.fold(lst) shouldBe 1
      Length.loop(lst) shouldBe 1
    }
    "return the correct length" in {
      (1 to 100).foreach { i =>
        Length.recursive(List.fill(i)(i)) shouldBe i
        Length.fold(List.fill(i)(i)) shouldBe i
        Length.loop(List.fill(i)(i)) shouldBe i
      }
    }
  }
}
