package harsha4

import scala.annotation.tailrec

class Four {
  def length(xs: List[Int]): Int = {
    @tailrec
    def _length(count: Int, remaining: List[Int]): Int = remaining match {
      case Nil => count
      case head :: tail => _length(count + 1, tail)
    }

    def _lengthWithFold(xs: List[Int]): Int = {
      xs.foldLeft(0)((b, a) => b + 1)
    }

    //    _length(0, xs)
    _lengthWithFold(xs)
  }
}
