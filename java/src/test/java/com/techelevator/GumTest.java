package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {

    private Gum gumTest;

    @Before
    public void set(){ gumTest = new Gum("U-Chews", new BigDecimal(0.85));}

    @Test
    public void test_getConsumptionSound(){
        String result = gumTest.getConsumptionNoise();
        Assert.assertEquals("Chew Chew, Yum!", result);
    }
}