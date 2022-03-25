import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestSubsekvensRegister {
    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        SubsekvensRegister subregTestDataLike = new SubsekvensRegister();
        SubsekvensRegister subregTestDataLitenLike = new SubsekvensRegister();

        // Henter og sjekker om det finnes en metadata.csv fil i mappene som er argumenter til programmet og tar vare på absoluttstien dems i en liste.
        for (int i = 0; i < args.length; i++) {
                File f = new File(args[i] + "/metadata.csv");

                if (!f.isFile()) {
                    continue;
                }

                paths.add(f.getAbsolutePath());
        }
        
        for (String path : paths) {
            if (path.contains("TestDataLitenLike")) {
                befolkSubsekvensRegister(path, subregTestDataLitenLike);
            } else {
                befolkSubsekvensRegister(path, subregTestDataLike);
            }
        }

        // Fletter sammen alle HashMaps i registrene
        flettAlle(subregTestDataLitenLike);
        flettAlle(subregTestDataLike);

        // Subsekvens med flest antall i TestDataLitenLike
        System.out.println("TestDataLitenLike: " + finnFlest(subregTestDataLitenLike.taUt()));

        // Subsekvens med flest antall i TestDataLike
        System.out.println("TestDataLike: " + finnFlest(subregTestDataLike.taUt()));

    }

    // Leser metadata.csv filene, lager og legger til immunrepetoarer i registeret
    public static void befolkSubsekvensRegister(String path, SubsekvensRegister subreg) {
        Scanner metafil = null;
        try {
            metafil = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen " + path);
            System.exit(1);
        }

        while (metafil.hasNextLine()) {
            String[] data = metafil.nextLine().split(",");
            String filnavn = path.replace("metadata.csv", data[0]);

            subreg.settInn(SubsekvensRegister.lesImmunrepetoar(filnavn));
        }
    }

    // Fletter alle HashMap i registeret og setter inn én HashMap (det er nå bare ett HashMap i registeret)
    public static void flettAlle(SubsekvensRegister subreg) {
        HashMap<String,Subsekvens> kombinertImmunrepetoar = new HashMap<>();
        while (subreg.stoerrelse() != 0) {
            kombinertImmunrepetoar = SubsekvensRegister.flettImmunrepetoar(kombinertImmunrepetoar, subreg.taUt());
        }
        subreg.settInn(kombinertImmunrepetoar);
    }

    // Finner subsekvens med flest forkomster i et immunrepetoar
    public static Subsekvens finnFlest(HashMap<String, Subsekvens> immunrepetoar) {
        int flestAntall = 0;
        Subsekvens subsekvensMedFlestAntall = null;

        for (Subsekvens subsekvens : immunrepetoar.values()) {
            if (subsekvens.hentAntall() > flestAntall) {
                flestAntall = subsekvens.hentAntall();
                subsekvensMedFlestAntall = subsekvens;
            }
        }

        return subsekvensMedFlestAntall;
    }
}
