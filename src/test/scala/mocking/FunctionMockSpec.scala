package mocking

import com.h2.services.Currency
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class FunctionMockSpec extends FlatSpec with Matchers with MockFactory {

  behavior of "Currency's Mocking"

  it should "be able to mock a higher-order function for any input argument and anyNumberOfTimes" in {
    val currencies: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

    def getCurrency(criteria: Currency => Boolean): List[Currency] = currencies.filter(criteria)


    val mocked = mockFunction[Currency, Boolean]

    mocked.expects(*).anyNumberOfTimes()

    getCurrency(mocked)

  }
}
