package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest {

    private Chips chipsTest;

    @Before
    public void set(){ chipsTest = new Chips("Stackers", new BigDecimal(1.45));}

    @Test
    public void test_getConsumptionSound(){
        String result = chipsTest.getConsumptionNoise();
        Assert.assertEquals("Crunch Crunch, Yum!", result);
    }
}