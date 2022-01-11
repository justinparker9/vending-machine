package com.techelevator;

import com.techelevator.view.LogWriter;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private Map<String, VendingMachineItem> inventory = new LinkedHashMap<String, VendingMachineItem>();

    public VendingMachine(){
        inventoryReader();
    }

    LogWriter log = new LogWriter();

    public void inventoryReader() {

        try (Scanner inputScanner = new Scanner(new File("vendingmachine.csv"))) {

            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();

                try {
                    String[] array = line.split("\\|");
                    String slot = array[0];
                    String name = array[1];
                    BigDecimal price = new BigDecimal(array[2]);
                    String type = array[3];

                    VendingMachineItem vendingMachineItem = null;
                    if(type.equals("Chip")){
                        vendingMachineItem = new Chips(name, price);
                    }
                    if(type.equals("Candy")){
                        vendingMachineItem = new Candy(name, price);
                    }
                    if(type.equals("Gum")){
                        vendingMachineItem = new Gum(name, price);
                    }
                    if(type.equals("Drink")){
                        vendingMachineItem = new Drink(name, price);
                    }

                    inventory.put(slot,vendingMachineItem);

                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BigDecimal balance = new BigDecimal(0.00);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney(int addedMoney){
        if (addedMoney == 1){
            BigDecimal oneDollar = new BigDecimal(1.00);
            balance = balance.add(oneDollar);
            try {
                log.writer("FEED MONEY", new BigDecimal(1.00), balance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (addedMoney == 2){
            BigDecimal twoDollars = new BigDecimal(2.00);
            balance = balance.add(twoDollars);
            try {
                log.writer("FEED MONEY", new BigDecimal(2.00), balance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (addedMoney == 5){
            BigDecimal fiveDollars = new BigDecimal(5.00);
            balance = balance.add(fiveDollars);
            try {
                log.writer("FEED MONEY", new BigDecimal(5.00), balance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (addedMoney == 10){
            BigDecimal tenDollars = new BigDecimal(10.00);
            balance = balance.add(tenDollars);
            try {
                log.writer("FEED MONEY", new BigDecimal(10.00), balance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(addedMoney + " is not a valid bill amount.");
        }

        System.out.println("Current balance is $" + balance);
    }

    public Collection<String> getSlots(){return inventory.keySet();}

    public VendingMachineItem getItem(String slot) {
        return inventory.get(slot);
    }

    public void productSelection(String userInput){
        if(!inventory.containsKey(userInput)){
            System.out.println("Sorry, that SlotID is invalid.");
        }
        if(inventory.containsKey(userInput)){
            BigDecimal productPrice = (inventory.get(userInput).getPrice());
            String value =  inventory.get(userInput).purchase();
           if(!value.equals("SOLD OUT.") && ((productPrice.compareTo(balance) == -1) || (productPrice.compareTo(balance) == 0))){
               balance = balance.subtract(productPrice);

               System.out.println(value);
               System.out.println("Remaining balance: " + balance);

               String productName = inventory.get(userInput).getName();
               String logInfo = productName + " " + userInput;
               try {
                   log.writer(logInfo, productPrice, balance);
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
           }
           else if(value.equals("SOLD OUT.")){
               System.out.println("Item is out of stock");
            }
           else if(productPrice.compareTo(balance) == 1){
               System.out.println("Please feed more money to purchase item. Current balance is " + balance);
           }
        }

    }

    public int[] getChange(double dollarValue){
        int cents = (int) Math.round(dollarValue*100);
        int[] change = {cents/25, (cents%=25)/10, (cents%=10)/5, cents%5};
        try {
            log.writer("GIVE CHANGE", balance, new BigDecimal(0.00));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return change;
    }
    public double convertedBalance(){
       double dBalance = balance.doubleValue();
       return dBalance;
    }

}
