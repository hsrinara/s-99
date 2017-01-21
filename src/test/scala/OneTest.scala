import org.scalatest.{FlatSpec, Matchers}

class OneTest extends FlatSpec with Matchers {
  "One " can " find last element in list " in {
    new One().last(List(1, 1, 2, 3, 5, 8)) should be (8)
  }

  "Two " can " find last element in single element list" in {
    new One().last(List(3)) should be (3)
  }

}
