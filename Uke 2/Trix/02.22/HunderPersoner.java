import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class HunderPersoner {
    public static void main(String[] args) {
        String filnavn = "navn.txt";
        Scanner fil = null;
        ArrayList<Hund> hunder = new ArrayList<>();
        ArrayList<Person> personer = new ArrayList<>();

        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen.");
        }
        
        while (fil.hasNextLine()) {
            String[] data = fil.nextLine().split(" ", 2);
            String type = data[0];
            String navn = data[1];

            if (type.startsWith("P")) {
                personer.add(new Person(navn));
            }
            else {
                hunder.add(new Hund(navn));
            }
        }

        System.out.println("\nPersoner: ");
        for (Person person : personer) {
            System.out.println(person.hentNavn());
        }

        System.out.println("\nHunder: ");
        for (Hund hund : hunder) {
            System.out.println(hund.hentNavn());
        }
    }
}
