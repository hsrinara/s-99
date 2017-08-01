package harsha17

import dsl.BaseTest

class SeventeenTest extends BaseTest {
//  Split a list into two parts.
//  The length of the first part is given. Use a Tuple for your result.
//
//  Example:
//
//    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//  res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  val seventeen = new Seventeen()

  "seventeen " can " split List" in {
    seventeen.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
      (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}
