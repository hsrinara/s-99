package harsha7

import org.scalatest.{FlatSpec, Matchers}

class SevenTest extends FlatSpec with Matchers {
  "Seven " can " flatten a nested list of a combination of list and simple types" in {
    new Seven().flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be(List(1, 1, 2, 3, 5, 8))
  }

  "Seven " can " flatten a simple nested list " in {
    new Seven().flatten(List(List(1, 2), List(3, 4))) should be(List(1, 2, 3, 4))
  }

  "Seven " can " do nothing to a flat list" in {
    new Seven().flatten(List(1, 2, 3, 4)) should be(List(1, 2, 3, 4))
  }

  "Seven " can " do nothing to a list of a single element" in {
    new Seven().flatten(Nil) should be(Nil)
  }

  "Seven " can " do nothing to an empty list" in {
    println(List(1,2,3,4).flatMap(x => List(x + 1)))
    println(List(1,2,3,4).map(x => x + 1))

    new Seven().flatten(Nil) should be(Nil)
  }
}
