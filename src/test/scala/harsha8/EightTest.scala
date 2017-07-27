package harsha8

import dsl.BaseTest

class EightTest extends BaseTest {
  "Eight " can " remove duplicates in a list" in {
    new Eight().removeDuplicates(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be(List('a, 'b, 'c, 'a, 'd, 'e))
  }

  "Eight " can " do nothing to list which has no duplicates" in {
    new Eight().removeDuplicates(List('a, 'b, 'c, 'd, 'e)) should
      be(List('a, 'b, 'c, 'd, 'e))
  }

  "Eight " can " do nothing to empty list" in {
    new Eight().removeDuplicates(Nil) should be(Nil)
  }

  "Eight " can " do nothing to list with single element" in {
    new Eight().removeDuplicates(List('a)) should be(List('a))
  }
}
