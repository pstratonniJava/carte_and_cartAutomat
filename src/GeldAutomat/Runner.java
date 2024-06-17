package GeldAutomat;

public class Runner {
    public static void main(String[] args) {
    Karte karte = new Karte(1234, "Ich");
    Automat geldAutomat = new Automat();
    geldAutomat.start(karte);
    }
}
