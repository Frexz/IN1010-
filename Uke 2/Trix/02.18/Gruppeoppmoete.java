import java.util.Scanner;
import java.io.File;

public class Gruppeoppmoete {
    
    // Deklarerer instansvariabler
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];

    // Konstruktør leser navn fra fil og fyller opp navn-arrayet
    public Gruppeoppmoete() {
        lesFraFil("gruppeliste.txt");
    }

    // Les fra fil
    private void lesFraFil(String filnavn) {
        Scanner fil = null;
        String studentNavn;

        try {
            fil = new Scanner(new File(filnavn));
        } catch (Exception e) {
            System.out.println("Kan ikke finne filen.");
        }

        for (int i = 0; i < 14; i++) {
            studentNavn = fil.nextLine();
            navn[i] = studentNavn;
        }
    }

    // Registrere oppmøte
    public void registrerOppmoete(String studentnavn) {
        for (int i = 0; i < 14; i++) {
            if (studentnavn.equals(navn[i])) {
                oppmoete[i] = true;;
            }
        }
    }

    // Skriv ut studenter
    public void skrivUtStudenter() {
        for (int i = 0; i < 14; i++) {
            System.out.printf("Student: %s\nOppmoett: %b\n", navn[i], oppmoete[i]);
        }
    }
}
