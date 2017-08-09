package harsha5

import scala.annotation.tailrec
import scala.collection.immutable.Nil

class Five {
  def reverse(xs: List[Int]): List[Int] = {
    @tailrec
    def _reverseWithRecursion(readFrom: List[Int], writeTo: List[Int]): List[Int] = {
      readFrom match {
        case Nil => writeTo
        case head :: tail => _reverseWithRecursion(tail, List(head) ++ writeTo)
      }
    }

    xs.foldLeft(List[Int]())((b: List[Int], a: Int) => a :: b)
    //  _reverseWithRecursion(xs)
  }
}
