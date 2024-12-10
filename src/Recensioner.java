import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Läsa och skriva recensioner
public class Recensioner extends Sida {

    public Recensioner() {
        System.out.println("Recensioner");
        System.out.println("Vill du läsa (1) eller skriva (2) recension?");
        int val = läsInput();
        if (val == 1) {
            System.out.println("Läsa");
            läsRecension();
        } else if (val == 2) {
            System.out.println("Skriva");
            skrivRecension();
        } else {
            System.out.println("Välj 1 eller 2");
            val = läsInput();
        }

    }

    public int läsInput() {
        Scanner scan = new Scanner(System.in);
        int val = 0;
        try {
            val = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Välj 1 eller 2");
            val = läsInput();
        }
        return val;
    }

    public void skrivRecension() {
        try (FileWriter writer = new FileWriter("recension.txt", true)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Skriv ert namn: ");
            String namn = scanner.nextLine();

            System.out.println("Skriv titel: ");
            String titel = scanner.nextLine();

            System.out.println("Skriv recension: ");
            String recension = scanner.nextLine();

            writer.write("Namn: " + namn + "\n");
            writer.write("Titel: " + titel + "\n");
            writer.write("Recension: " + recension + "\n");
            writer.write("............................\n");

            System.out.println("Recension har sparats.");
        } catch (IOException e) {
            System.out.println("Kunde inte skriva till fil");
            e.printStackTrace();
        }
    }

    public void läsRecension() {
        try (BufferedReader reader = new BufferedReader(new FileReader("recension.txt"))) {
            String rad;
            System.out.println("Recensioner : \n");
            while ((rad = reader.readLine()) != null){
                System.out.println(rad);
            }
        } catch (IOException e) {
            System.out.println("Kunde inte läsa fil");
            e.printStackTrace();
        }
    };
}
