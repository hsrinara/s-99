package harsha7

class Seven {
  def flatten(input: List[Any]): List[Any] =
    input flatMap {
      case integer: Int => List(integer)
      case list: List[_] => flatten(list)
    }
}
