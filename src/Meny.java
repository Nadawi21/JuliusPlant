import java.util.Scanner;

public class Meny {

    SidFactory factory = new SidFactory();

    public Meny() {

        while (true) {
            visaMeny();
            int input = läsAnvändarInput();
            Sida sida = factory.visaSida(input);
            sida.gåTillMeny();
        }

    }

    private void visaMeny() {
        System.out.println("Välkommen till Julius Plants bokningssytem!");

        System.out.println("Skriv en siffra för att välja i menyn");
        System.out.println("1. Portfolion\n" +
                "2. Information\n" +
                "3. Recensioner\n" +
                "4. Boka/avboka tid\n");
    }

    private int läsAnvändarInput() {
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i > 0 && i < 5) {
                return i;
            } else {
                System.out.println("Skriv en siffra mellan 1 - 4");
                läsAnvändarInput();
            }
        } else {
            System.out.println("Skriv en siffra mellan 1 - 4");
            läsAnvändarInput();
        }
        return 0;
    }

    public static void main(String[] args) {
        new Meny();
    }
}