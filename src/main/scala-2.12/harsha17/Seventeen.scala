package harsha17

import scala.annotation.tailrec

sealed trait Splitter {
  def split(index: Int, symbols: List[Symbol]): (List[Symbol], List[Symbol])
}

class FunctionalSplitter extends Splitter {
  override def split(index: Int, symbols: List[Symbol]): (List[Symbol], List[Symbol]) = {
    def accumulateOverIndex(elementsBeforeIndex: List[Symbol],
                            elementsAfterIndex: List[Symbol],
                            symbol: Symbol, currentIndex: Int): (List[Symbol], List[Symbol]) =
      if (currentIndex < index) (elementsBeforeIndex :+ symbol, elementsAfterIndex)
      else (elementsBeforeIndex, elementsAfterIndex :+ symbol)

    symbols
      .zipWithIndex
      .foldLeft((List[Symbol](), List[Symbol]()))((acc, symbolIndex) => accumulateOverIndex(
        acc._1,
        acc._2,
        symbolIndex._1,
        symbolIndex._2))
  }
}

class RecursiveSplitter extends Splitter {
  override def split(index: Int, symbols: List[Symbol]): (List[Symbol], List[Symbol]) = {
    @tailrec
    def splitOverIndexRecursive(currentIndex: Int, remaining: List[Symbol], resultSoFar: (List[Symbol], List[Symbol])): (List[Symbol], List[Symbol]) = {
      (remaining, currentIndex) match {
        case (r, _) if r.isEmpty => resultSoFar
        case (r, i) if i < index => splitOverIndexRecursive(i + 1, r.tail, (resultSoFar._1 :+ r.head, resultSoFar._2))
        case (r, i) => splitOverIndexRecursive(i + 1, r.tail, (resultSoFar._1, resultSoFar._2 :+ r.head))
      }
    }

    splitOverIndexRecursive(0, symbols, (List[Symbol](), List[Symbol]()))
  }
}