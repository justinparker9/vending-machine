package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest {

    private Candy candyTest;

    @Before
    public void set(){ candyTest = new Candy("Cowtales", new BigDecimal(1.50));}

    @Test
    public void test_getConsumptionSound(){
        String result = candyTest.getConsumptionNoise();
        Assert.assertEquals("Munch Munch, Yum!", result);
    }
}
