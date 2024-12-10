import java.io.Serializable;
import java.time.LocalDate;

public class Bokning implements Serializable {

    private LocalDate datum;
    private String namn;
    private String mail;

    public Bokning(LocalDate datum) {
        this.datum = datum;
    }

    public Bokning(LocalDate datum, String namn, String mail) {
        this.datum = datum;
        this.namn = namn;
        this.mail = mail;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
