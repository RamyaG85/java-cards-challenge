package com.company;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CreditCard extends Card{
    private double creditLimit;
    private double currentAmountOnCard;
    //private String dueDate;
    private int dueDay;

    //public CreditCard(String bankName, boolean isUKBank, String name, String cardType, double creditLimit, String dueDate) {
    public CreditCard(String bankName, boolean isUKBank, String name, String cardType, double creditLimit, int dueDay) {
        super(bankName, isUKBank, name, cardType);
        this.creditLimit = creditLimit;
        this.currentAmountOnCard=0;
        //this.dueDate = dueDate;
        if (dueDay >=1 && dueDay <=31) {
            this.dueDay = dueDay;
        } else{
            System.out.println("Not a valid Due Date. Due date should be in between 1 to 31 range");
        }
    }

    public void spend(double amount) throws ParseException {
        if(!(amount <= 0)) {
            if (creditLimit - amount >= 0) {
                Transaction txn = new Transaction(amount, true);
                this.Txns.add(txn);
                currentAmountOnCard += amount;
                creditLimit -= amount;
                //long daysUntilDue = calculateDaysUntilDue(txn.getTransactionDate());
                long daysUntilDue = calculateDaysUntilDue1(txn.getTransactionDate());
                System.out.println("Spent Amount : " + currentAmountOnCard + ". And it is due in - " + daysUntilDue + " days\n" + "Balance Credit Limit on card for spending is : " + creditLimit);
            } else {
                System.out.println("Sufficient credit limit is not available. Current Credit Limit on card for spending is : " + creditLimit);
            }
        } else{
            System.out.println("Invalid Transaction amount entered. Please recheck.");
        }
    }

//    public long calculateDaysUntilDue(Date txnDate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        Date parsedDueDate = sdf.parse(dueDate);
//
//        long diffInMillies = Math.abs(parsedDueDate.getTime() - txnDate.getTime());
//        long daysUntilDue = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//        return daysUntilDue;
//    }

    public long calculateDaysUntilDue1(Date txnDate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        int currDay = cal.get(Calendar.DAY_OF_MONTH);
        int Month = cal.get(Calendar.MONTH);
        int Year = cal.get(Calendar.YEAR);

        if(dueDay < currDay ) {
            if (Month == 11) {
                Month = 0;
                Year += 1;
            } else {
                Month += 1;
            }
        }
        Date dueDate = new GregorianCalendar(Year, Month , dueDay).getTime();

        long diffInMillies = Math.abs(dueDate.getTime() - txnDate.getTime());
        long daysUntilDue = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return daysUntilDue;
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
                        "CreditLimit : " + creditLimit + '\n' +
                        "CurrentAmountOnCard : " + this.currentAmountOnCard + '\n' +
                        //", dueDate='" + dueDate + '\'' +
                        "DueDay : " + dueDay + '\n' +
                        "******** END ******** "
        );
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "Txns=" + Txns +
                ", creditLimit=" + creditLimit +
                ", currentAmountOnCard=" + currentAmountOnCard +
                //", dueDate='" + dueDate + '\'' +
                ", dueDay='" + dueDay + '\'' +
                '}';
    }
}
