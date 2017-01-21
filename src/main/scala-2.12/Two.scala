class Two {
  def penultimate(xs: List[Int]): Int = {
    if (xs == null) throw new IllegalArgumentException("Cannot penultimate null")
    if (xs.isEmpty) throw new IllegalArgumentException("Cannot penultimate empty list")
    if (xs.tail.isEmpty) throw new IllegalArgumentException("Cannot penultimate list of 1")
    def _penultimate(xs: List[Int]): Int = {
      if (xs.tail.tail.isEmpty) xs.head
      else _penultimate(xs.tail)
    }

    def _penultimateWithPatternMatching(xs: List[Int]): Int = {
      xs match {
        case null => throw new IllegalArgumentException("Cannot penultimate null")
        case Nil => throw new IllegalArgumentException("Cannot penultimate empty list")
        case head :: Nil => throw new IllegalArgumentException("Cannot penultimate list of 1")
        case head :: second :: Nil => head
        case head :: second :: tail  => _penultimateWithPatternMatching(tail)
      }
    }
    _penultimateWithPatternMatching(xs)
//    _penultimate(xs)
  }


}
