package harsha4

import dsl.BaseTest

class FourTest extends BaseTest {
//  P04 (*) Find the number of elements of a list.
//    Example:1
//    scala> length(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 6

  "Four " can " find length of empty list" in {
    new Four().length(Nil) should be (0)
  }

  "Four " can " find length of list of size 1" in {
    new Four().length(List(3)) should be (1)
  }

  "Four " can " find length of list" in {
    new Four().length(List(1, 1, 2, 3, 5, 8)) should be (6)
  }
}
