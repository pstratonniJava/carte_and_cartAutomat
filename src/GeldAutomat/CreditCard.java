package GeldAutomat;

import java.time.LocalDate;

public class CreditCard extends Card {
    private double balance ;
    private double creditLimit;
    private int withoutInterestDays;
    private LocalDate interestDate;


    public CreditCard(int pin, String owner, LocalDate date, double creditLimit, int withoutInterestDays) {
        super(pin, owner, date);
        this.balance = creditLimit;
        this.creditLimit = creditLimit;
        this.withoutInterestDays = withoutInterestDays;
    }

    public double getBalance() {
        return balance;
    }

    public boolean setBalance(double amount, boolean input) {
        if (!input  && amount > this.balance){
            System.out.println("Nicht genug Geld");
            return false;
        }
        if (!input && this.creditLimit <= this.balance && this.balance - amount < this.creditLimit){
            this.interestDate = LocalDate.now().plusDays(withoutInterestDays);
        }
        this.balance = input ? this.balance + amount: this.balance - amount;
        if (this.balance > this.creditLimit){
            this.interestDate = null;
        }
        return true;
    }
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.balance += creditLimit - this.creditLimit;
        this.creditLimit = creditLimit;
    }

    public int getWithoutInterestDays() {
        return withoutInterestDays;
    }

    public void setWithoutInterestDays(int withoutInterestDays) {
        this.withoutInterestDays = withoutInterestDays;
    }

    public LocalDate getInterestDate() {
        return interestDate;
    }
}
