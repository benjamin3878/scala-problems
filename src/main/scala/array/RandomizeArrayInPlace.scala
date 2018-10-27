package array

object RandomizeArrayInPlace {

  def apply[A](arr: Array[A]): Array[A] = {
    arr.indices.foreach { i =>
      val swapIndex = scala.util.Random.nextInt(arr.length)
      val temp = arr(i)
      arr(i) =  arr(swapIndex)
      arr(swapIndex) = temp
    }
    arr
  }

}
