package harsha20

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{MustMatchers, WordSpec}

class TwentyTest extends WordSpec with MustMatchers {

  /**
    * Return the list and the removed element in a Tuple. Elements are numbered from 0.
    * *
    * Example:
    * *
    * scala> removeAt(1, List('a, 'b, 'c, 'd))
    * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
    */
  private val functionalRemoveAt = new FunctionalRemoveAt()
  private val recursiveRemoveAt = new RecursiveRemoveAt()
  private val implementations = List(functionalRemoveAt, recursiveRemoveAt)

  "twenty can rotate list by N places" should {
    val allScenarios = org.scalatest.prop.Tables.Table(
      ("title", "implementations", "k", "input", "output"),
      ("Scenario from question", implementations, 1, List('a, 'b, 'c, 'd), (List('a, 'c, 'd), 'b)),
      ("empty list", implementations, 0, Nil, (Nil, null))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementations, k, input, output) =>
      s"$title" in {
        implementations
          .map(impl => impl.removeAt(k, input))
          .map(y => y mustBe output)
      }
    }
  }

  "twenty throw error when indexing beyond input" in {
    a[IndexOutOfBoundsException] must be thrownBy functionalRemoveAt.removeAt(1, Nil)
    a[IndexOutOfBoundsException] must be thrownBy recursiveRemoveAt.removeAt(1, Nil)
  }
}
