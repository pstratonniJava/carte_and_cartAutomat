package GeldAutomat;


import java.time.LocalDate;




public class Card {
    private int pin;
    private String owner;
    private double balance = 0;
    private LocalDate date;


    public Card(int pin, String owner, LocalDate date) {
        this.pin = pin;
        this.owner = owner;
        this.date = date;
    }
    public int getPin() {
        return pin;
    }

    public void setPin(int newPin) {
        this.pin = newPin;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getData(){
        return date;
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
