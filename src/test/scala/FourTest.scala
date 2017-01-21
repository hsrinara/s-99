import org.scalatest.{FlatSpec, Matchers}

class FourTest extends FlatSpec with Matchers {
//  P04 (*) Find the number of elements of a list.
//    Example:1
//    scala> length(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 6

  "Four " can " find length of empty list" in {
    new Four().length(Nil) should be (0)
  }
1
  "Four " can " find length of list" in {
    new Four().length(List(1, 1, 2, 3, 5, 8)) should be (6)
  }
}
