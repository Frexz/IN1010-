import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Studentsystem {

    private HashMap<String, Student> studenter;
    private HashMap<String, Fag> emner;
    private Scanner fil;
    private Scanner inp;
    private String filnavn = "emnestudenter.txt";
    
    public Studentsystem() {
        studenter = new HashMap<>();
        emner = new HashMap<>();
        inp = new Scanner(System.in);
        lesFraFil();
    }

    private void lesFraFil() {

        // Deklarerer variabler
        String emnekode;
        String studentnavn;
        Fag fag = null;
        Student student = null;
        
        // Sjekker om filen finnes i mappen
        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen.");
            System.exit(1);
        }

        // Leser fra fil og oppretter datastrukturen
        while (fil.hasNextLine()) {
            String data = fil.nextLine();

            if (data.startsWith("*")) {

                // Oppretter et fag og legger det til i systemet
                 emnekode = data.substring(1);
                 fag = new Fag(emnekode);
                 emner.put(emnekode, fag);
            } else {

                // Oppretter en student og legger det til i systemet
                studentnavn = data;

                // Sjekker om en student allerede finnes i systemet
                if (!studenter.containsKey(studentnavn)) {
                    student = new Student(studentnavn);
                    studenter.put(studentnavn, student);
                } else {
                    student = studenter.get(studentnavn);
                }
                
                // Legger student til i fag og fag til student
                fag.leggTilStudent(student);
                student.leggTilFag(fag);
            }
        }
    }

    public void meny() {
        System.out.println("***** MENY *****");
        System.out.println("1. Skriv ut emnet med flest studenter.");
        System.out.println("2. Skriv ut student med flest fag.");
        System.out.println("3. Skriv ut alle studenter i fag.");
        System.out.println("4. Skriv ut alle fag til student.");
        System.out.println("5. Legg til fag til student.");
        System.out.println("6. Legg student til i fag.");
        System.out.println("7. Fjern fag fra student.");
        System.out.println("8. Fjern student fra fag.");
        System.out.println("9. Legg til ny student.");
        System.out.println("10. Legg til nytt fag.");
        System.out.println("0. Avslutt program.");
    }

    public void ordrelokke() {
        int valg = -1;

        while (valg != 0) {

            switch (valg) {
                case 1:
                    flestStudenter();
                    break;
                case 2:
                    flestFag();
                    break;
                case 3:
                    String emnekode = inp.next();
                    skrivUtStudenterIFag(emnekode);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;   
            }

            meny();
            valg = inp.nextInt();
        }
    }

    // Skriver ut mest populære emne
    public void flestStudenter() {
        int antall = 0;
        Fag fagMedFlest = null;

        for (Fag fag : emner.values()) {
            
            if (fag.antallStudenter() > antall) {
                antall = fag.antallStudenter();
                fagMedFlest = fag;
            }
        }

        System.out.printf("Faget med flest studenter er %s.\n", fagMedFlest.hentEmnekode());
    }

    // Skriver ut student med flest fag
    public void flestFag() {
        int antall = 0;
        Student studentMedFlest = null;

        for (Student student : studenter.values()) {
            
            if (student.antallFag() > antall) {
                antall = student.antallFag();
                studentMedFlest = student;
            }
        }

        System.out.printf("Studenten med flest fag er %s.\n", studentMedFlest.hentNavn());
    }

    // Skriver ut alle studenter i et fag
    public void skrivUtStudenterIFag(String emnekode) {
        System.out.printf("Studenter i %s:\n ", emnekode);
        
        for (Fag fag : emner.values()) {
            if (emnekode == fag.hentEmnekode()) {
                fag.skrivUtStudenter();
            }
        }
    }
}
