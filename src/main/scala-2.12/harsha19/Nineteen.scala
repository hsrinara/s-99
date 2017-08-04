package harsha19

import scala.annotation.tailrec

class Nineteen {
  def rotate(N: Int, input: List[Symbol]): List[Symbol] = {
    def functionalRotate =
      input.slice(Integer.min(N, input.length), input.length) ++ input.slice(0, N)

    @tailrec
    def recursiveRotate(remaining: Int, state: List[Symbol]): List[Symbol] =
      remaining match {
        case 0 => state
        case _ => recursiveRotate(remaining - 1, state.tail :+ state.head)
      }

    val funRotate = functionalRotate
    val recRotate = recursiveRotate(N, input)
    if (funRotate != recRotate) {
      throw new RuntimeException("bug")
    }
    recRotate
  }
}
