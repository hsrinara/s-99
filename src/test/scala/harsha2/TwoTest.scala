package harsha2

import org.scalatest.{FlatSpec, Matchers}

class TwoTest extends FlatSpec with Matchers {
  //  P02 (*) Find the last but one element of a list.
  //  Example:
  //    scala> penultimate(List(1, 1, 2, 3, 5, 8))
  //  res0: Int = 5

  "penultimate " can " find penultimate element in list" in {
    new Two().penultimate(List(1, 1, 2, 3, 5, 8)) should be(5)
  }

  "penultimate " should " throw exception when list is null " in {
    assert(intercept[IllegalArgumentException] {
      new Two().penultimate(null)
    }.getMessage == "Cannot penultimate null")
  }

  "penultimate " should " throw exception when list is empty" in {
    assert(intercept[IllegalArgumentException] {
      new Two().penultimate(List())
    }.getMessage == "Cannot penultimate empty list")
  }

  "penultimate " should " throw exception when list has one element" in {
    assert(intercept[IllegalArgumentException] {
      new Two().penultimate(List(2))
    }.getMessage == "Cannot penultimate list of 1")
  }

  "penultimate " should " find element for list of size 2" in {
    new Two().penultimate(List(2, 3)) should be(2)
  }
}
