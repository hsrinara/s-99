package harsha21

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

class TwentyOneTest extends WordSpec with MustMatchers {
  private val implementations = List(new BuiltInInsertIntoAPosition())
  /**
  P21 (*) Insert an element at a given position into a list.
    Example:

    scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
    res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
    */
  "twentyone " should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "newElement", "position", "input", "output"),
      ("Scenario from question", implementations, 'new, 1, List('a, 'b, 'c, 'd), List('a, 'new, 'b, 'c, 'd))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementations, newElement, position, input, expectedOutput) =>
      s"$title" in {
        implementations
          .map(impl => impl.insertIntoAtPosition(position, newElement, input))
          .map(actual => actual mustBe expectedOutput)
      }
    }
  }
}
