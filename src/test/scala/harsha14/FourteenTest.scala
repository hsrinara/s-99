package harsha14

import dsl.BaseTest

class FourteenTest extends BaseTest {

//  P14 (*) Duplicate the elements of a list.
//    Example:
//    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  private val fourteen = new Fourteen()

  "fourteen " can " duplicate elements in list" in {
    fourteen.duplicate(List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }
}
