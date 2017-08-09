package harsha9

import scala.annotation.tailrec

class Nine {

  type ListOfLists[A] = List[List[A]]

  def packConsecutiveDuplicates[A](xs: List[A]): ListOfLists[A] = {
    type ConsecutiveFilter = A => Boolean

    def splitWhile(toEat: List[A], filter: ConsecutiveFilter): (List[A], List[A]) = {
      val consecutiveUntil = toEat.indexWhere(s => !filter(s))
      if (consecutiveUntil == -1) (Nil, toEat)
      else toEat.splitAt(consecutiveUntil).swap
    }

    @tailrec
    def _packConsecutive(working: List[A], result: ListOfLists[A]): ListOfLists[A] = {
      if (working.isEmpty) result
      else {
        val (remaining, packed) = splitWhile(working, _ == working.head)
        val updatedResult = result :+ packed
        if (remaining.isEmpty) updatedResult
        else _packConsecutive(remaining, updatedResult)
      }
    }

    _packConsecutive(xs, Nil)
  }
}
