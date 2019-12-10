package org.greeting

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Ignore

// special class for running test within IDE
@RunWith(JUnit4::class)
class CalculatorTestJavaHelper : CalculatorTest()
