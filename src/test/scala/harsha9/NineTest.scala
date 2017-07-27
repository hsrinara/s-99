package harsha9

import dsl.BaseTest

class NineTest extends BaseTest {
  "Nine " can " pack consecutive duplicates into list" in {
    new Nine().packConsecutiveDuplicates(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be(List(
        List('a, 'a, 'a, 'a),
        List('b),
        List('c, 'c),
        List('a, 'a),
        List('d),
        List('e, 'e, 'e, 'e)))
  }

  "Nine " can " pack two consecutive elements" in {
    new Nine().packConsecutiveDuplicates(List('a, 'a)) should be(List(List('a, 'a)))
  }

  "Nine " can " pack three consecutive elements" in {
    new Nine().packConsecutiveDuplicates(List('a, 'a, 'a)) should be(List(List('a, 'a, 'a)))
  }

  "Nine " can " return empty list when input is empty" in {
    new Nine().packConsecutiveDuplicates(Nil) should be(Nil)
  }
}