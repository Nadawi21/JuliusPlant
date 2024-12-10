import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Boka, avboka och se lediga tider
public class Kalender extends Sida {

    List<Bokning> bokningar = new ArrayList<>();
    String filnamn = "bokningar.ser";

    public Kalender() {

        läsInBokningar(filnamn);

        System.out.println("Vill du: \n1. Boka\n2. Avboka");
        int val = läsInput();
        if (val == 1) {
            boka();
        } else if (val == 2) {
            avboka();
        } else {
            System.out.println("Välj 1 eller 2");
            val = läsInput();
        }

    }

    public void sparaBokningar(List<Bokning> bokningar) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            for (Bokning bokning : bokningar) {
                oos.writeObject(bokning);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void läsInBokningar(String filnamn) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                Bokning bokning = (Bokning) obj;
                bokningar.add(bokning);
            }
        } catch (EOFException e) {
            System.out.println("Bokningarna har lästs in");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void boka() {
        List<LocalDate> ledigaTider = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            LocalDate datum = LocalDate.now().plusDays(i);
            boolean datumHittades = false;
            for (Bokning bokning : bokningar) {
                if (bokning.getDatum().equals(datum)) {
                    datumHittades = true;
                    break;
                }
            }

            if (!datumHittades) {
                ledigaTider.add(datum);
            }
        }
        for (int i = 0; i < ledigaTider.size(); i++) {
            System.out.println(i + ": "+ ledigaTider.get(i));
        }


        System.out.println("Välj ett datum:");
        Scanner scan = new Scanner(System.in);
        int val = -1;
        try {
            val = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Välj en siffra mellan 1 - " + ledigaTider.size());
        }
        LocalDate datum = ledigaTider.get(val);
        scan.nextLine();
        System.out.print("Ange ditt namn: ");
        String namn = scan.nextLine();
        System.out.print("Ange din mailadress: ");
        String mail = scan.nextLine();
        bokningar.add(new Bokning(datum, namn, mail));
        sparaBokningar(bokningar);
        System.out.println("Bokning registrerad");
    }

    public void avboka() {
        System.out.println("Ange din mailadress: ");
        Scanner scan = new Scanner(System.in);
        String mail = scan.nextLine();
        boolean bokningHittades = false;
        for (int i = 0; i < bokningar.size(); i++) {
            if (bokningar.get(i).getMail().equals(mail)) {
                System.out.println("Din bokning " + bokningar.get(i).getDatum() + " är avbokad");
                bokningar.remove(i);
                bokningHittades = true;
            }
        }
        if (!bokningHittades) {
            System.out.println("Hittade ingen bokning med angiven mailadress");
        }
        sparaBokningar(bokningar);
    }

}
