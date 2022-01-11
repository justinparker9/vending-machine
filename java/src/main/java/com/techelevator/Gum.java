package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem{

    public Gum(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getConsumptionNoise() { return "Chew Chew, Yum!";}
}

