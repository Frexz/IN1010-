import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Studentsystem {

    private HashMap<String, Student> studenter;
    private HashMap<String, Fag> fag;
    private Scanner fil = null;
    private String filnavn;
    
    public Studentsystem() {
        studenter = new HashMap<>();
        fag = new HashMap<>();
        lesFraFil();
    }

    public void lesFraFil() {
        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen.");
        }

        while (fil.hasNextLine()) {
            String data = fil.nextLine();
            String emnekode;
            String studentnavn;
            Fag fag;
            Student student;

            if (data.startsWith("*")) {
                 emnekode = data.substring(1);
                 fag = new Fag(emnekode);
            }
        }
    }
    
}
