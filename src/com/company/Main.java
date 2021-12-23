package com.company;

public class Main {

    public static void main(String[] args) {

        // Credit Card functionality
        //CreditCard creditCard = new CreditCard("DB", true, "Ramya", "Credit", 50000, "01/15/2022");
        CreditCard creditCard = new CreditCard("DB", true, "Ramya", "Credit", 50000, 30);
        System.out.println(creditCard);
        System.out.println(creditCard.accountSummary());
        try {
            creditCard.spend(5000);
            creditCard.spend(15000);
            creditCard.spend(10000);
            creditCard.spend(20000);
            creditCard.spend(5000);
            creditCard.spend(-3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(creditCard.getTxns());
        System.out.println(creditCard.accountSummary());


        // Debit Card functionality
        DebitCard debitCard = new DebitCard("HSBC", true, "Ramya", "Debit", 27000.36);
        System.out.println(debitCard);
        System.out.println(debitCard.accountSummary());

        debitCard.spend(5000);
        debitCard.spend(15000);
        debitCard.spend(10000);
        debitCard.spend(20000);
        debitCard.spend(5000);
        debitCard.spend(-3000);

        System.out.println(debitCard.getTxns());
        System.out.println(debitCard.accountSummary());



    }
}
