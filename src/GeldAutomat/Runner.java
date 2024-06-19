package GeldAutomat;

import java.time.LocalDate;
import java.time.YearMonth;

public class Runner {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int endDay = Integer.parseInt(YearMonth.now().atEndOfMonth().toString().split("-")[2]);
        date = LocalDate.of(date.getYear(), date.getMonth(),endDay);
        Card karte = new DebitCard(1234, "Ich",date);
        Automat geldAutomat = new Automat();
        geldAutomat.start(karte);
    }
}
