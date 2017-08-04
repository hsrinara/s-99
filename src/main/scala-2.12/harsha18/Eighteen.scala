package harsha18

class Eighteen {
  def slice(start: Int, end: Int, input: List[Symbol]): List[Symbol] =
    input
      .zipWithIndex
      .foldLeft(List[Symbol]())((acc, symbolIndex) =>
        if (isWithinSlice(start, end, symbolIndex)) acc :+ symbolIndex._1
        else acc
      )

  private def isWithinSlice(start: Int, end: Int, symbolIndex: (Symbol, Int)) =
    symbolIndex._2 >= start && symbolIndex._2 < end
}
