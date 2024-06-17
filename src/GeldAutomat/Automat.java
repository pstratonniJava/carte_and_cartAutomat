package GeldAutomat;

import java.util.Scanner;

public class Automat {
    Card card;
    int countPin;

    public void start(Card card) {
        Scanner scanner = new Scanner(System.in);
        this.countPin = 0;
        this.card = card;
        String out = "";
        while (true){
            System.out.println("""
                Was wünschen Sie?
                Bei Ausgabe drücken Sie 1
                Bei Eingabe drücken Sie 2
                Bei Kontostand drücken Sie 3
                PIN-änderung drücken Sie 4
                Karte aus? Drücken Sie 5
                """);
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    this.changeBalance(false);
                    break;
                case 2:
                    this.changeBalance(true);
                    break;
                case 3:
                    this.balance();
                    break;
                case 4:
                    this.pinChange();
                    break;
                case 5:
                    out = "y";
                    break;
                default:
                    System.out.println("Fehlerhafte der Auswahl");
            }
            if (out.equals("y")) {
                break;
            }
            if(this.countPin==3) {
                System.out.println("Session beendet. Sie haben drei mal falsche PIN eingegeben");
                break;
            }
        }
        scanner.close();
    }

    public boolean pinChek(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int pin = scanner.nextInt();
            if(pin!= this.card.getPin()) {
                this.countPin++;
                if(this.countPin==3){
                    return false;
                }
                System.out.println("Fehlerhafte PIN\nVersuchen Sie noch mal");
            }else {
                this.countPin = 0;
                return true;
            }
        }
    }

    public void changeBalance(boolean isInPut) {
        System.out.printf("Um Geld %s, geben Sie PIN ein\n", isInPut ? "einzugeben":"auszugeben");
        if (!this.pinChek()){
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Wie viele Geld wollen Sie %s\n",isInPut ? "eingeben":"ausgeben");
        double amout = scanner.nextDouble();
        boolean success = this.card.setBalance(amout, isInPut);
        if(success) {
            System.out.printf("%s\n",isInPut ? "Geld wurde erfolgreich gespeichert":"Nehmen Sie Geld");
            System.out.println("Ihr Kontostand ist " + this.card.getBalance());
        }
    }

    public void balance() {
        System.out.println("Um Kontostand zu prüfen, geben Sie ein");
        if (!this.pinChek()){
            return;
        }
        System.out.println("Ihr Kontostand ist " + this.card.getBalance());
    }

    public void pinChange() {
        System.out.println("Um PIN zu ändern, geben Sie alte PIN ein");
        if (!this.pinChek()){
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie neue PIN ein");
        int pin = scanner.nextInt();
        this.card.setPin(pin);
        System.out.println("PIN wurde erfolgreich gespeichert");
    }
}
