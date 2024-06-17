package GeldAutomat;

public class Runner {
    public static void main(String[] args) {
    Card karte = new Card(1234, "Ich");
    Automat geldAutomat = new Automat();
    geldAutomat.start(karte);
    }
}
