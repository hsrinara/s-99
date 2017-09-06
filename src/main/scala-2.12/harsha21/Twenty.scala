package harsha21

sealed trait InsertIntoAtPosition[T] {
  def insertIntoAtPosition(position: Int, newElement: T, xs: List[T]): List[T]
}

final class BuiltInInsertIntoAPosition extends InsertIntoAtPosition[Symbol] {
  override def insertIntoAtPosition(position: Int, newElement: Symbol, xs: List[Symbol]): List[Symbol] = {
    val splitList = xs.splitAt(position)
    (splitList._1 :+ newElement) ++ splitList._2
  }
}

