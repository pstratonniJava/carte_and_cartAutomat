package GeldAutomat;


import java.time.LocalDate;




public abstract class Card {
    private int pin;
    private String owner;
    private final LocalDate expiryDate ;

    public Card(int pin, String owner, LocalDate expiryDate) {
        this.pin = pin;
        this.owner = owner;
        this.expiryDate = expiryDate;

    }
    public int getPin() {
        return pin;
    }

    public void setPin(int newPin) {
        this.pin = newPin;
    }



    public LocalDate getData(){
        return expiryDate;
    }

    public abstract double getBalance();
    public abstract boolean setBalance(double amount, boolean input);

}
