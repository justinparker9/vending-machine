package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTest {

    private Drink drinkTest;

    @Before
    public void set(){ drinkTest = new Drink("Cola", new BigDecimal(1.25));}

    @Test
    public void test_getConsumptionSound(){
        String result = drinkTest.getConsumptionNoise();
        Assert.assertEquals("Glug Glug, Yum!", result);
    }
}