import javax.sound.sampled.Port;
import java.util.Scanner;

public class Startsida {



    public Startsida() {
        visaMeny();
        int input = läsAnvändarInput();
        switch (input) {
            case 1:
                new Portfolio();
                break;
            case 2:
                new Information();
                break;
            case 3:
                new Recensioner();
                break;
            case 4:
                new Bokningar();
                break;
        }
    }

    private void visaMeny() {
        System.out.println("Välkommen till Julius Plants bokningssytem!");

        System.out.println("Skriv en siffra för att välja i menyn");
        System.out.println("1. Portfolion\n" +
                "2. Information\n" +
                "3. Recensioner\n" +
                "4. Boka/avboka tid");
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
}
