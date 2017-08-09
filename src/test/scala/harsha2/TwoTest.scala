package harsha2

import org.scalatest.prop.{TableDrivenPropertyChecks, Tables}
import org.scalatest.{MustMatchers, WordSpec}

import scala.reflect.ClassTag

class TwoTest extends WordSpec with MustMatchers {
  //  P02 (*) Find the last but one element of a list.
  //  Example:
  //    scala> penultimate(List(1, 1, 2, 3, 5, 8))
  //  res0: Int = 5

  private val implementations = List(new RecursiveWithPatternMatchingPenultimate(), new RecursivePenultimate())

  "penultimate can find penultimate element in list" should {
    val allScenarios = Tables.Table(
      ("title", "implementations", "input", "output"),
      ("Scenario from question", implementations, List(1, 1, 2, 3, 5, 8), 5),
      ("find penultimate when list is size 2", implementations, List(2, 3), 2)
    )

    TableDrivenPropertyChecks.forAll(allScenarios) { (title, implementations, input, expectedOutput) =>
      s"$title" in {
        implementations
          .map(impl => impl.penultimate(input))
          .map(actual => actual mustBe expectedOutput)
      }
    }
  }

  "penultimate error handling" should {
    verifyException[IllegalArgumentException]("cannot penultimate null", implementations, (p) => p.penultimate(null))
    verifyException[IllegalArgumentException]("cannot penultimate empty list", implementations, (p) => p.penultimate(Nil))
    verifyException[IllegalArgumentException]("cannot penultimate element with single element", implementations, (p) => p.penultimate(List(1)))
  }

  def verifyException[T : ClassTag](title: String, implementations: Seq[Penultimate], test: (Penultimate) => Unit): Unit = {
    implementations.zipWithIndex.foreach(implIndex => {
      val impl = implIndex._1
      val index = implIndex._2
      s"$title - $index" in {
        an[T] should be thrownBy test(impl)
      }
    })
  }
}
