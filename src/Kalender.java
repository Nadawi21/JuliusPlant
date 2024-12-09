import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Boka, avboka och se lediga tider
public class Kalender extends Sida {

    List<Bokning> bokningar = new ArrayList<>();

    public Kalender() {

        bokningar.add(new Bokning(LocalDate.of(2024, 12, 12), "Pontus", "pontus@mail.se"));
        List<LocalDate> ledigaTider = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            LocalDate datum = LocalDate.now().plusDays(i);
            boolean datumHittades = false;
            for (Bokning bokning : bokningar) {
                if (bokning.datum.equals(datum)) {
                    datumHittades = true;
                } else {
                    ledigaTider.add(datum);
                }
            }

            if (!datumHittades) {
                System.out.println(ledigaTider.size() + ": "+ datum);
            }

        }
        System.out.println("Kalender");

    }
}
