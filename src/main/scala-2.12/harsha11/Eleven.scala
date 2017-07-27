package harsha11

import harsha9.Nine

class Eleven {
  private val nine = new Nine()

  def runLengthEncoding(list: List[Symbol]): List[Any] = {
    def eitherSingleElementOrFrequencyOfElements(sequenceOfSameSymbols: Seq[Symbol]): Any =
      if (sequenceOfSameSymbols.size == 1) sequenceOfSameSymbols.head
      else (sequenceOfSameSymbols.size, sequenceOfSameSymbols.head)

    nine.packConsecutiveDuplicates(list).map(eitherSingleElementOrFrequencyOfElements)
  }
}
