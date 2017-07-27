package harsha15

class Fifteen {
  def duplicate(count: Int, symbols: List[Symbol]): List[Symbol] =
    symbols flatMap { symbol => List.fill(count)(symbol) }
}
