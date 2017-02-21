package harsha6

import org.scalatest.{FlatSpec, Matchers}

class SixTest extends FlatSpec with Matchers {
  "Six " can " find out whether list is palindrome" in {
    new Six().isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
  }

  "Six " can " say list of single element is palindrome" in {
    new Six().isPalindrome(List(1)) should be(true)
  }

  "Six " can " say empty list is not palindrome" in {
    new Six().isPalindrome(Nil) should be(false)
  }
}
