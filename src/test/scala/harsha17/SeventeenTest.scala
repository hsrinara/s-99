package harsha17

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

class SeventeenTest extends WordSpec with MustMatchers {
//  Split a list into two parts.
//  The length of the first part is given. Use a Tuple for your result.
//
//  Example:
//
//    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//  res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  private val implementations = List(new FunctionalSplitter(), new RecursiveSplitter())

  "seventeen can split List" should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "N", "input", "output"),
      ("example from question", implementations, 3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementation, N, input, output) => {
      s"$title" in {
        implementation
          .map(impl => impl.split(N, input))
          .map(actual => actual mustBe output)
      }
    }}
  }
}
