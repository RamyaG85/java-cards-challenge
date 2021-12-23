package com.company;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
    private double txnAmount ;
    private Timestamp transactionDate;
    private boolean isDebit;

    public Transaction(double txnAmount, boolean isDebit) {
        this.txnAmount = txnAmount;
        this.transactionDate = new Timestamp(new Date().getTime());
        this.isDebit = isDebit;
    }

    public double getTxnAmount() {
        return txnAmount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public boolean isDebit() {
        return isDebit;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txnAmount=" + txnAmount +
                ", transactionDate=" + transactionDate +
                ", isDebit=" + isDebit +
                '}';
    }
}
