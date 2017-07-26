package harsha10

import org.scalatest.{FlatSpec, Matchers}

class TenTest extends FlatSpec with Matchers {
  /**
    * Use the result of 9. to implement the so called
    * run length encoding data compression method.
    * Consecutive duplicates of elements are encoded
    * as tuples (N, E) where N is the number of
    * duplicates of the element E.
    */
  "Ten " can " pass given example" in {
    new Ten().runEncode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  "Ten " can " work on empty list" in {
    new Ten().runEncode(Nil) should be(Nil)
  }

  "Ten " can " calculate run length encoding with single letter" in {
    new Ten().runEncode(List('a)) should be(List((1, 'a)))
    new Ten().runEncode(List('a, 'a)) should be(List((2, 'a)))
  }

  "Ten " can " calculate run length encoding with break in middle" in {
    new Ten().runEncode(List('a, 'b, 'a, 'a)) should be(List((1, 'a), (1, 'b), (2, 'a)))
  }
}
