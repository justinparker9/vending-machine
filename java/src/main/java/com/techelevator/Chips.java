package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{

    public Chips(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getConsumptionNoise() { return "Crunch Crunch, Yum!";}
}

