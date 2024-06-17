package GeldAutomat;

import java.time.LocalDate;
import java.time.YearMonth;

public class Runner {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int endDay = Integer.parseInt(YearMonth.now().atEndOfMonth().toString().split("-")[2]);
        Card karte = new Card(1234, "Ich", LocalDate.of(date.getYear(), date.getMonth(),endDay));
        Automat geldAutomat = new Automat();
        geldAutomat.start(karte);
    }
}
