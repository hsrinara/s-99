package harsha16

import scala.annotation.tailrec

class Sixteen {
  def dropEveryN(N: Int, symbols: List[Symbol]): List[Symbol] = {

    @tailrec def dropEveryNRecursive(current: Int, remaining: List[Symbol], result: List[Symbol]): List[Symbol] = {
      if (remaining.isEmpty) result
      else {
        val shouldBeDropped = current == N
        dropEveryNRecursive(
          if (shouldBeDropped) 1 else current + 1, remaining.tail,
          if (shouldBeDropped) result else result :+ remaining.head)
      }
    }

    def dropEveryNFunctional(dropEvery: Int, list: List[Symbol]): List[Symbol] = {
      val filteredList = list.zipWithIndex filter { x => (x._2 + 1) % dropEvery != 0 }
      filteredList map { _._1}
    }

    val result = dropEveryNRecursive(1, symbols, Nil)
    if (result != dropEveryNFunctional(N, symbols)) throw new RuntimeException("bug!")
    result
  }
}
