import kotlin.test.Test
import kotlin.test.assertEquals

open class CalculatorTest {

    @Test
    fun testSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
