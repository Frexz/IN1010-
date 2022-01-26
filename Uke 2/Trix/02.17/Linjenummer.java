import java.util.Scanner;
import java.io.File;

public class Linjenummer {
    public static void main(String[] args) {
        Scanner fil = null;
        String filnavn = "mary.txt";
        int num = 1;
        String linje = "";

        try {
            fil = new Scanner(new File(filnavn));
        } 
        catch (Exception e) {
            System.out.printf("Finner ikke filen %s.", filnavn);
        }

        while (fil.hasNextLine()) {
            linje = fil.nextLine();
            linje = "# " + Integer.toString(num) + ": " + linje;
            System.out.println(linje);
            num ++;
        }
    }
}
