package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogWriter {

    public void writer(String actionType, BigDecimal amount, BigDecimal balance) throws FileNotFoundException {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(new File("./log.txt"), true))){

            String printToday = today.toString();
            String printTime = now.toString().substring(0, now.toString().length()-10);
            String printAmount = amount.toString();
            String printBalance = balance.toString();

            logWriter.println(printToday + " " + printTime + " " + actionType + " $" + printAmount + " $" + printBalance);


        } catch (Exception e){
            e.getMessage();
        }
    }
}
