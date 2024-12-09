import java.time.LocalDate;

public class Bokning {

    LocalDate datum;
    String namn;
    String mail;

    public Bokning(LocalDate datum, String namn, String mail) {
        this.datum = datum;
        this.namn = namn;
        this.mail = mail;
    }
}
