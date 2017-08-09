package harsha3

import scala.annotation.tailrec

class Three {
  def kthElement(k: Int, xs: List[Int]): Int = {
    @tailrec
    def _kthElement(counter: Int, xs: List[Int]): Int = counter match {
      case value if value == k => xs.head
      case _ => _kthElement(counter + 1, xs.tail)
    }

    _kthElement(0, xs)
  }
}
