package harsha12

import dsl.BaseTest

class TwelveTest extends BaseTest {
//  Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
//  Example:
//
//    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
//  res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  private val twelve = new Twelve()

  "twelve " can " decode run length encoding" in {
    twelve.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) should be(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }
}
