package GeldAutomat;

import java.time.LocalDate;

public class DebitCard extends Card {
    private double balance = 0;

    public DebitCard(int pin, String owner, LocalDate date) {
        super(pin, owner, date);
    }

    public double getBalance() {
        return balance;
    }

    public boolean setBalance(double amount, boolean input) {
        if (!input  && amount > this.balance){
            System.out.println("Nicht genug Geld");
            return false;
        }
        this.balance = input ? this.balance + amount: this.balance - amount;

        return true;
    }
}
