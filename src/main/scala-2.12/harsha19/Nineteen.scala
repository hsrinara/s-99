package harsha19

import scala.annotation.tailrec

sealed trait Rotator {
  def rotate(N: Int, input: List[Symbol]): List[Symbol]
}

class FunctionalRotator extends Rotator {
  override def rotate(N: Int, input: List[Symbol]): List[Symbol] = {
    input.slice(Integer.min(N, input.length), input.length) ++ input.slice(0, N)
  }
}

class RecursiveRotator extends Rotator {
  override def rotate(N: Int, input: List[Symbol]): List[Symbol] = {
    @tailrec
    def recursiveRotate(remaining: Int, state: List[Symbol]): List[Symbol] =
      remaining match {
        case 0 => state
        case _ => recursiveRotate(remaining - 1, state.tail :+ state.head)
      }

    recursiveRotate(N, input)
  }
}