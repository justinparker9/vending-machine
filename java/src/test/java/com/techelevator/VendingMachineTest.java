package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setup(){ vendingMachine = new VendingMachine(); }

    @Test
    public void test_feedMoney_when_addedMoney_is_1(){
        vendingMachine.feedMoney(1);
        Assert.assertEquals(new BigDecimal(1), vendingMachine.balance);
    }

    @Test
    public void test_feedMoney_when_addedMoney_is_2(){
        vendingMachine.feedMoney(2);
        Assert.assertEquals(new BigDecimal(2), vendingMachine.balance);
    }

    @Test
    public void test_feedMoney_when_addedMoney_is_5(){
        vendingMachine.feedMoney(5);
        Assert.assertEquals(new BigDecimal(5), vendingMachine.balance);
    }

    @Test
    public void test_feedMoney_when_addedMoney_is_10(){
        vendingMachine.feedMoney(10);
        Assert.assertEquals(new BigDecimal(10), vendingMachine.balance);
    }

    @Test
    public void test_feedMoney_when_addedMoney_is_not_a_valid_amount(){
        vendingMachine.feedMoney(-100);
        BigDecimal balance = vendingMachine.balance;
        Assert.assertEquals(balance, new BigDecimal(0));
    }

    @Test
    public void test_productSelection_when_SlotID_is_valid(){
        vendingMachine.feedMoney(5);
        vendingMachine.productSelection("A1");
        Assert.assertEquals(new BigDecimal(1.95), vendingMachine.balance);
    }

    @Test
    public void test_productSelection_when_SlotID_is_not_valid(){
        vendingMachine.productSelection("A8");
        Assert.assertEquals(new BigDecimal(0), vendingMachine.balance);
    }

    @Test
    public void test_getChange_when_balance_is_0(){
        int[] result = vendingMachine.getChange(0);
        int[] expected = {0,0,0,0};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void test_getChange_when_there_is_a_balance(){
        int[] result = vendingMachine.getChange(1.25);
        int[] expected = {5,0,0,0};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void test_convertedBalance(){
        BigDecimal balance = new BigDecimal(5.00);
        double result = balance.doubleValue();
        double expected = 5;
        Assert.assertEquals(expected, result,.001);
    }
}
