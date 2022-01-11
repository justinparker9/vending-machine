package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItem {
    private static final int STARTING_INVENTORY = 5;

    private String name;
    private BigDecimal price;
    private int remainingCount;

    public VendingMachineItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.remainingCount = STARTING_INVENTORY;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public String purchase(){
        if(remainingCount > 0){
            remainingCount--;
            return getConsumptionNoise();
        }
        return "SOLD OUT.";
    }

    public abstract String getConsumptionNoise();

    @Override
    public String toString(){
        return String.format("%-20s $%-5.2f", name, price);
    }
}
