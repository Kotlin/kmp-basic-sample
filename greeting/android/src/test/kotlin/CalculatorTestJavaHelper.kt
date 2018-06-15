import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Ignore

// special class for running test within IDE
@Ignore
@RunWith(JUnit4::class)
class CalculatorTestJavaHelper : CalculatorTest()
