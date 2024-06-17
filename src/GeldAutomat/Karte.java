package GeldAutomat;

public class Karte {
    private int pin;
    private String anhaber;
    private double Kontostand = 0;


    public Karte(int pin, String anhaber) {
        this.pin = pin;
        this.anhaber = anhaber;
    }
    public int getPin() {
        return pin;
    }

    public void setPin(int neuPin) {
        this.pin = neuPin;
    }

    public double getBalance() {
        return Kontostand;
    }

    public boolean setBalance(double betrag, boolean eingeben) {
        if (!eingeben  && betrag > this.Kontostand){
            System.out.println("Nicht genug Geld");
            return false;
        }
        this.Kontostand = eingeben ? this.Kontostand + betrag: this.Kontostand - betrag;
        return true;
    }


}
