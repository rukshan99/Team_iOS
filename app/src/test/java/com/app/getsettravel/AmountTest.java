package com.app.getsettravel;

import static org.junit.Assert.*;
import org.junit.Test;

public class AmountTest {

    Amount amount = new Amount();
    @Test
    public void TestCalculateBookingCost(){

        float actual = amount.calculateBookingCost( 25000,"Double",3,2);
        float expected = 300000;

        assertEquals("Process of calculating the booking cost failed.",expected,actual,0.001);
    }
}
