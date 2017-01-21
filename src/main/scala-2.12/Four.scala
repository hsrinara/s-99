class Four {
  def length(xs: List[Int]): Int = {
    def _length(count: Int, remaining: List[Int]): Int = remaining match {
      case Nil => count
      case _ => _length(count + 1, remaining.tail)
    }

    _length(0, xs)
  }
}
