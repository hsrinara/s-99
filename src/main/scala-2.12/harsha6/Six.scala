package harsha6

import scala.annotation.tailrec

class Six {
  def isPalindrome(xs: List[Int]): Boolean = {
    @tailrec def _isPalindrome(remaining: List[Int]): Boolean = {
      remaining match {
        case last :: Nil => true
        case head :: middle :: last :: Nil => head == last
        case head :: tail =>
          if (head != tail.last) false
          else _isPalindrome(tail.slice(0, tail.size - 1))
      }
    }
    if (xs.length % 2 == 0) false
    else _isPalindrome(xs)
  }
}
