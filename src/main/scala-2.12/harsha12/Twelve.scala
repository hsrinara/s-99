package harsha12

class Twelve {
  def decode(tuples: List[(Int, Symbol)]): List[Symbol] =
    tuples.flatMap { case (count, symbol) => List.fill(count)(symbol) }
}
