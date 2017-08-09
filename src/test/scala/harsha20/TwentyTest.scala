package harsha20

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

import scala.reflect.ClassTag

class TwentyTest extends WordSpec with MustMatchers {

  /**
    * Return the list and the removed element in a Tuple. Elements are numbered from 0.
    * *
    * Example:
    * *
    * scala> removeAt(1, List('a, 'b, 'c, 'd))
    * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
    */
  private val implementations = List(new FunctionalRemoveAt(), new RecursiveRemoveAt())

  "twenty can rotate list by N places" should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "k", "input", "output"),
      ("Scenario from question", implementations, 1, List('a, 'b, 'c, 'd), (List('a, 'c, 'd), 'b)),
      ("Single element list", implementations, 0, List('a), (List(), 'a))
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementations, k, input, expectedOutput) =>
      s"$title" in {
        implementations
          .map(impl => impl.removeAt(k, input))
          .map(actual => actual mustBe expectedOutput)
      }
    }
  }

  "throw error when indexing negatively" should {
    verifyExceptionForAll[IndexOutOfBoundsException]("indexing negatively", implementations, (r) => r.removeAt(-1, List('a)))
    verifyExceptionForAll[IndexOutOfBoundsException]("index empty list", implementations, (r) => r.removeAt(0, Nil))
    verifyExceptionForAll[IndexOutOfBoundsException]("index beyond list", implementations, (r) => r.removeAt(2, List('a)))
  }

  def verifyExceptionForAll[E : ClassTag](title: String, implementations: Seq[RemoveAt], throwsException: (RemoveAt) => Unit): Unit = {
    implementations.zipWithIndex.foreach(implIndex => {
      val implementation = implIndex._1
      val index: Int = implIndex._2
      s"$title - $index" in {
        an[E] should be thrownBy {
          throwsException(implementation)
        }
      }
    })
  }
}
