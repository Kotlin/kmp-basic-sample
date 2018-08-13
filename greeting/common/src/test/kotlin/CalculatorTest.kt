import kotlin.test.Test
import kotlin.test.assertEquals
import org.greeting.*

open class CalculatorTest {

    @Test
    fun testSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }

    @Test
    fun testFactory() {
        val product = Factory.create(mapOf("user" to "jetbrains"))
        assertEquals(product.user, "jetbrains")
    }
}

