package harsha16

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

class SixteenTest extends WordSpec with MustMatchers {
  //  P16 (**) Drop every Nth element from a list.
  //  Example:
  //
  //    scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  private val implementations = List(new FunctionalDropEveryN(), new RecursiveDropEveryN())

  "sixteen can drop every N elements from List" should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "N", "input", "output"),
      ("Single element list", implementations, 3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)),
      ("Drop from empty liset", implementations, 3, Nil, Nil),
      ("Drop every N elements from long list", implementations, 2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), List('a, 'c, 'e, 'g, 'i, 'k)),
      ("Drop every element from list", implementations, 1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), Nil),
      ("Drop nothing on short list", implementations, 10, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i), List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementation, N, input, output) => {
      s"$title" in {
        implementation
          .map(impl => impl.dropEveryN(N, input))
          .map(actual => actual mustBe output)
      }
    }}
  }
}
