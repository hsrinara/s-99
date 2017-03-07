package harsha9

import scala.annotation.tailrec

class Nine {

  type ListOfLists[A] = List[List[A]]

  def packConsecutiveDuplicates(xs: List[Symbol]): ListOfLists[Symbol] = {
    type ConsecutiveFilter = Symbol => Boolean

    def splitWhile(toEat: List[Symbol], filter: ConsecutiveFilter): (List[Symbol], List[Symbol]) = {
      val consecutiveUntil = toEat.indexWhere(s => !filter(s))
      if (consecutiveUntil == -1) (Nil, toEat)
      else toEat.splitAt(consecutiveUntil).swap
    }

    @tailrec
    def _packConsecutive(working: List[Symbol], result: ListOfLists[Symbol]): ListOfLists[Symbol] = {
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
