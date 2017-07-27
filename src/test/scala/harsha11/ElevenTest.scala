package harsha11

import dsl.BaseTest

class ElevenTest extends BaseTest {

  /***
    Modified run-length encoding.
    Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into
    the result list. Only elements with duplicates are transferred as (N, E) terms.

    Example:

    scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    */

  "Eleven " can " encode run length encoding" in {
    new Eleven().runLengthEncoding(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }
}
