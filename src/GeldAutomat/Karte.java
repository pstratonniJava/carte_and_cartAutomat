package GeldAutomat;

public class Karte {
    private int pin;
    private String owner;
    private double balance = 0;


    public Karte(int pin, String owner) {
        this.pin = pin;
        this.owner = owner;
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

    public boolean setBalance(double betrag, boolean eingeben) {
        if (!eingeben  && betrag > this.balance){
            System.out.println("Nicht genug Geld");
            return false;
        }
        this.balance = eingeben ? this.balance + betrag: this.balance - betrag;
        return true;
    }


}
