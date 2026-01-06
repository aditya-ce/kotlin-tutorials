package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 20.0
        val tipPercent = 15.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(3)
        val actualTip =  calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}