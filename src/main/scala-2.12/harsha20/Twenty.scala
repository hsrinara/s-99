package harsha20

import scala.annotation.tailrec

sealed trait RemoveAt {
  def removeAt(k: Int, symbols: List[Symbol]): (List[Symbol], Symbol)

  def verifyIndexBounds(k: Int, symbols: List[Symbol]): Unit =
    if (k > symbols.length || symbols.isEmpty || Integer.signum(k) == -1) throw new IndexOutOfBoundsException
}

class FunctionalRemoveAt extends RemoveAt {
  override def removeAt(k: Int, symbols: List[Symbol]): (List[Symbol], Symbol) = {
    verifyIndexBounds(k, symbols)
    val left = symbols.slice(0, k) ++ symbols.slice(Integer.min(k + 1, symbols.length), symbols.length)
    val right = symbols(k)
    (left, right)
  }
}

class RecursiveRemoveAt extends RemoveAt {
  override def removeAt(k: Int, symbols: List[Symbol]): (List[Symbol], Symbol) = {
    @tailrec
    def transform(current: Int, remaining: List[Symbol], result: (List[Symbol], Symbol)): (List[Symbol], Symbol) = {
      if (remaining.isEmpty) result
      else if (current == k) transform(current + 1, remaining.tail, (result._1, remaining.head))
      else transform(current + 1, remaining.tail, (result._1 :+ remaining.head, result._2))
    }

    verifyIndexBounds(k, symbols)
    transform(0, symbols, (Nil, null))
  }
}
