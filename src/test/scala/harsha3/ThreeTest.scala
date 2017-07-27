package harsha3

import dsl.BaseTest

class ThreeTest extends BaseTest {
//  P03 (*) Find the Kth element of a list.
//  By convention, the first element in the list is element 0.
//  Example:

//    scala> nth(2, List(1, 1, 2, 3, 5, 8))
//  res0: Int = 2

  "kth element " can " find the kth element of a list" in {
    new Three().kthElement(2, List(1, 1, 2, 3, 5, 8)) should be (2)
  }

  "kth element" can " find the first element of a list" in {
    new Three().kthElement(0, List(9, 1, 2, 3, 5, 8)) should be (9)
  }

  "kth element " can " find second element of a list" in {
    new Three().kthElement(1, List(9, 7, 2, 3, 5, 8)) should be (7)
  }
}
