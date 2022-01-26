import java.util.Scanner;
import java.io.File;

public class TemperaturLeser {
    public static void main(String[] args) {
        String [] temperaturer = new String[12];
        Scanner fil = null;
        String filnavn = "Temperatur.txt";
        int teller = 0;

        try {
            fil = new Scanner(new File(filnavn));
        } 
        catch (Exception e) {
            System.out.printf("Fant ikke filen %s.", filnavn);
            System.exit(1);
        }

        while (fil.hasNextLine()) {
            temperaturer[teller] = fil.nextLine();
            teller ++;
        }

        for (String temp : temperaturer) {
            System.out.println(temp);
        }
    }
}
