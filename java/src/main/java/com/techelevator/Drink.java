package com.techelevator;

import java.math.BigDecimal;

public class Drink extends VendingMachineItem{

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getConsumptionNoise() { return "Glug Glug, Yum!";}
}
