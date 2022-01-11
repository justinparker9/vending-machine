package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem{

    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getConsumptionNoise() { return "Munch Munch, Yum!";}
}

