import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Sida {

//    void visaInnehåll(){};

    void gåTillMeny(){
        System.out.println("Vill du gå tillbaka till menyn? [j/n]");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("j")) {
            //
        } else if (input.equals("n")) {
            System.exit(0);
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
}
