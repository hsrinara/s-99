package harsha10

import harsha9.Nine

class Ten {
  private val nine = new Nine()
  def runEncode(list: List[Symbol]): List[(Int, Symbol)] = {
    nine.packConsecutiveDuplicates(list)
      .map((sequenceOfSameSymbols) => (sequenceOfSameSymbols.size, sequenceOfSameSymbols.head))
  }
}
