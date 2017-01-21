class Four {
  def length(xs: List[Int]): Int = {
    def _length(count: Int, remaining: List[Int]): Int = remaining match {
      case Nil => count
      case head :: tail => _length(count + 1, tail)
    }

    _length(0, xs)
  }
}
