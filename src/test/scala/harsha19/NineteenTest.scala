package harsha19

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

class NineteenTest extends WordSpec with MustMatchers {
  private val implementations = List(new FunctionalRotator(), new RecursiveRotator())
  /**
  Examples:

scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    */

  "nineteen rotate list by N places" should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "N", "input", "output"),
      ("Example from question", implementations, 3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementation, N, input, output) => {
      s"$title" in {
        implementation
          .map(impl => impl.rotate(N, input))
          .map(actual => actual mustBe output)
      }
    }}
  }
}
