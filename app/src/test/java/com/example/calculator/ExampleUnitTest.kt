package com.example.calculator

import org.junit.Assert.*
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun evaluateAlgebraicExpressionTest() {
        val test = evaluateAlgebraicExpression("10+9")
        println(test)
    }
}