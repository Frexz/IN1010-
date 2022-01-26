import java.util.Scanner;
import java.io.File;

public class FraFil {
    public static void main(String[] args) {
        String filnavn = "tekst.txt";

        try {
            Scanner fil = new Scanner(new File(filnavn));

            while (fil.hasNextLine()) {
                String linje = fil.nextLine();
                System.out.println(linje);
            }
        } 
        catch (Exception e) {
            System.out.printf("Kan ikke finne %s!\n", filnavn);
            System.exit(1);
        }

        
    }
}
