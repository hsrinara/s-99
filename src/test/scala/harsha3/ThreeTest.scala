package harsha3

import org.scalatest.{FlatSpec, Matchers}

class ThreeTest extends FlatSpec with Matchers {
//  P03 (*) Find the Kth element of a list.
//  By convention, the first element in the list is element 0.
//  Example:

//    scala> nth(2, List(1, 1, 2, 3, 5, 8))
//  res0: Int = 2

  "harsha3.Three " can " find the kth element of a list" in {
    new Three().kthElement(2, List(1, 1, 2, 3, 5, 8)) should be (2)
  }

  "harsha3.Three " can " find the first element of a list" in {
    new Three().kthElement(0, List(9, 1, 2, 3, 5, 8)) should be (9)
  }

  "harsha3.Three " can " find second element of a list" in {
    new Three().kthElement(1, List(9, 7, 2, 3, 5, 8)) should be (7)
  }
}
