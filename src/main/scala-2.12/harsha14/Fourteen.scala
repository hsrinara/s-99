package harsha14

class Fourteen {
  def duplicate(symbols: List[Symbol]): List[Symbol] =
    symbols flatMap { symbol => List.fill(2)(symbol) }
}
