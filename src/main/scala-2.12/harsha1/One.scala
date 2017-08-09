package harsha1

import scala.annotation.tailrec

class One {
  def last(xs: List[Int]): Int = {
    @tailrec
    def _last(xs: List[Int], last: Int): Int = {
      if (xs.isEmpty) last
      else _last(xs.tail, xs.head)
    }

    if (xs == null) throw new IllegalArgumentException("cannot last null")
    else _last(xs, xs.head)
  }
}
