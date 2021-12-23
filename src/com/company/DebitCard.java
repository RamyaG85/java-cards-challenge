package com.company;

public class DebitCard extends Card{

    private double balance;

    public DebitCard(String bankName, boolean isUKBank, String name, String cardType, double balance) {
        super(bankName, isUKBank, name, cardType);
        this.balance = balance;
    }

    public void spend(double amount){
        if(!(amount <= 0)) {
            if(balance - amount > 0) {
                Transaction txn = new Transaction(amount, true);
                this.Txns.add(txn);
                balance-=amount;
                System.out.println("Current balance is : "+ balance );
            } else{
                System.out.println("Sufficient balance is not available. Current balance is : "+ balance );
            }
        } else{
            System.out.println("Invalid Transaction amount entered. Please recheck.");
        }
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
                        "Balance : " + balance + '\n' +
                        "******** END ******** "
        );
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "Txns=" + Txns +
                ", balance=" + balance +
                '}';
    }
}
