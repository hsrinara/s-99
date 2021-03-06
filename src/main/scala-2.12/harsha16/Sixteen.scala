package harsha16

import scala.annotation.tailrec

sealed trait DropEveryN {
  def dropEveryN(indexToDrop: Int, list: List[Symbol]): List[Symbol]
}

class FunctionalDropEveryN extends DropEveryN {
  override def dropEveryN(indexToDrop: Int, list: List[Symbol]): List[Symbol] = {
    def shouldDropElement(symbolIndex: (Symbol, Int)): Boolean = (symbolIndex._2 + 1) % indexToDrop != 0

    def toSymbol(symbolIndex: (Symbol, Int)): Symbol = symbolIndex._1

    list.zipWithIndex.filter(shouldDropElement).map(toSymbol)
  }
}

class RecursiveDropEveryN extends DropEveryN {
  override def dropEveryN(N: Int, symbols: List[Symbol]): List[Symbol] = {

    @tailrec
    def dropEveryNRecursive(current: Int, remaining: List[Symbol], result: List[Symbol]): List[Symbol] = {
      (current, remaining) match {
        case (_, r) if r.isEmpty => result
        case (c, r) if c == N => dropEveryNRecursive(1, r.tail, result)
        case (c, r) => dropEveryNRecursive(c + 1, r.tail, result :+ r.head)
      }
    }

    dropEveryNRecursive(1, symbols, Nil)
  }
}