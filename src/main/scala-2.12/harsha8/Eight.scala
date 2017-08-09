package harsha8

import scala.annotation.tailrec

class Eight {
  def removeDuplicates(xs: List[Symbol]): List[Symbol] = {
    @tailrec
    def _notMatchedState(remaining: List[Symbol], resultSoFar: List[Symbol]): List[Symbol] = {
      remaining match {
        case Nil => resultSoFar
        case last :: Nil => resultSoFar :+ last
        case first :: second :: tail =>
          if (first == second) _matchedState(tail, resultSoFar :+ first, first)
          else _notMatchedState(second :: tail, resultSoFar :+ first)
      }
    }

    @tailrec
    def _matchedState(remaining: List[Symbol], resultSoFar: List[Symbol], matchedElem: Symbol): List[Symbol] = {
      remaining match {
        case Nil => resultSoFar
        case last :: Nil => resultSoFar
        case head :: tail =>
          if (head == matchedElem) _matchedState(tail, resultSoFar, matchedElem)
          else _notMatchedState(head :: tail, resultSoFar)
      }
    }

    _notMatchedState(xs, Nil)
  }
}
