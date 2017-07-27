package harsha15

import dsl.BaseTest

class FifteenTest extends BaseTest {

  private val fifteen = new Fifteen()

  "fifteen" can " duplicate N times elements in list" in {
    fifteen.duplicate(3, List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }
}
