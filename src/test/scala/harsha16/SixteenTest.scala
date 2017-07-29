package harsha16

import dsl.BaseTest

class SixteenTest extends BaseTest {
  //  P16 (**) Drop every Nth element from a list.
  //  Example:
  //
  //    scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  private val sixteen = new Sixteen()
  "sixteen" can " drop every N elements from List" in {
    sixteen.dropEveryN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  "sixteen " can "drop drop every N elements from empty List" in {
    sixteen.dropEveryN(3, Nil) should be(Nil)
  }

  "sixteen " can "drop every N elements from long List" in {
    sixteen.dropEveryN(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('a, 'c, 'e, 'g, 'i, 'k))
  }

  "sixteen " can "drop every element from List" in {
    sixteen.dropEveryN(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(Nil)
  }

  "sixteen " can "drops nothing on short list" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    sixteen.dropEveryN(10, list) should be(list)
  }


}
