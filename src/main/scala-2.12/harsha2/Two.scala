package harsha2

import scala.annotation.tailrec
import scala.collection.immutable.::

class Two {
  def penultimate(xs: List[Int]): Int = {
    @tailrec
    def _penultimate(xs: List[Int]): Int = {
      if (xs.tail.tail.isEmpty) xs.head
      else _penultimate(xs.tail)
    }

    @tailrec
    def _penultimateWithPatternMatching(xs: List[Int]): Int = xs match {
      case Nil => throw new IllegalArgumentException("Cannot penultimate empty list")
      case head :: Nil => throw new IllegalArgumentException("Cannot penultimate list of 1")
      case head :: second :: Nil => head
      case head :: second :: tail => _penultimateWithPatternMatching(tail)
    }

    if (xs == null) throw new IllegalArgumentException("Cannot penultimate null")

    _penultimateWithPatternMatching(xs)
    //    _penultimate(xs)
  }
}
