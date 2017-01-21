import org.scalatest.{FlatSpec, FunSuite, Matchers}

class FiveTest extends FlatSpec with Matchers {
  "Five " can " reverse an empty list " in {
    new Five().reverse(Nil) should be(Nil)
  }

  "Five " can " reverse a single element list " in {
    new Five().reverse(List(2)) should be(List(2))
  }

  "Five " can " reverse a list with two elements" in {
    new Five().reverse(List(2, 3)) should be(List(3, 2))
  }

  "Five " can " reverse a list with three elements" in {
    new Five().reverse(List(2, 3, 10)) should be(List(10, 3, 2))
  }
}
