import scala.collection.immutable.::

class Two {
  def penultimate(xs: List[Int]): Int = {
    def _penultimate(xs: List[Int]): Int = {
      if (xs.tail.tail.isEmpty) xs.head
      else _penultimate(xs.tail)
    }

    def _penultimateWithPatternMatching(xs: List[Int]): Int = xs match {
      case head :: second :: Nil => head
      case head :: second :: tail => _penultimateWithPatternMatching(tail)
    }

    if (xs == null) throw new IllegalArgumentException("Cannot penultimate null")
    if (xs == Nil) throw new IllegalArgumentException("Cannot penultimate empty list")
    if (xs.tail == Nil) throw new IllegalArgumentException("Cannot penultimate list of 1")

    _penultimateWithPatternMatching(xs)
    //    _penultimate(xs)
  }
}
