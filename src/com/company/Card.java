package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Card {
    String bankName;
    int yearOpened;
    boolean isUKBank;
    String name;
    String cardType;
    ArrayList<Transaction> Txns ;
    //private double amount;

    public Card(String bankName, boolean isUKBank, String name, String cardType) {
        this.bankName = bankName;
        this.yearOpened = Calendar.getInstance().get(Calendar.YEAR);
        this.isUKBank = isUKBank;
        this.name = name;
        this.cardType = cardType;
        this.Txns = new ArrayList<>();
        System.out.println("***** A new card is created. ********");
    }

    //    public Card () {
//        System.out.println("A new card is created.");
//    }

    public String getBankName() {
        return bankName;
    }

    public int getYearOpened() {
        return yearOpened;
    }

    public boolean isUKBank() {
        return isUKBank;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public String getCardType() {
        return cardType;
    }

    public List<String> getTxns() {
        return Txns.stream().map(Txn ->
          String.format(
                "\n" +
                "TxnAmount : " + Txn.getTxnAmount() + ", " +
                "TxnDate : " + Txn.getTransactionDate() + ", " +
                "isDebit : " + Txn.isDebit()
                )
        ).collect(Collectors.toList());
    }

//    public double getAmount() {
//        return amount;
//    }

    public void setTxns(ArrayList<Transaction> txns) {
        Txns = txns;
    }

    public String accountSummary() {
        return String.format(
            "******** Account Summary ******** \n" +
            "Name : " + name + '\n' +
            "Bank Name : " + bankName + '\n' +
            "Year Opened : " + yearOpened + '\n' +
            "IsUKBank : " + isUKBank + '\n' +
            "Card Type : " + cardType + '\n' +
            "Prev Txns : " + Txns + '\n' +
            //"Amount : " + amount + '\n' +
            "******** END ******** "
        );
    }

    public void spend(double amount) throws ParseException {};
}
