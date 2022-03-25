import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SubsekvensRegister implements Iterable<HashMap<String,Subsekvens>> {
    ArrayList<HashMap<String,Subsekvens>> register = new ArrayList<>();

    // Legger til et HashMap i registeret
    public void settInn(HashMap<String,Subsekvens> subs) {
        register.add(subs);
    }

    // Henter ut et HashMap av registeret (det første)
    public HashMap<String, Subsekvens> taUt() {
        HashMap<String,Subsekvens> immurepetoar = register.get(0);
        register.remove(0);
        return immurepetoar;
    }

    // Returnerer antall HashMap i registeret
    public int stoerrelse() {
        return register.size();
    }

    // Leser og oppretter en HashMap med subsekvenser
    public static HashMap<String,Subsekvens> lesImmunrepetoar(String filnavn) {
        HashMap<String,Subsekvens> subs = new HashMap<>();
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen " + filnavn);
        }

        // Leser hver linje
        while (fil.hasNextLine()) {
            String sekvens = fil.nextLine();

            // Avslutter programmet hvis en sekvens er kortere enn 3 lang
            if (sekvens.length() < 3) {
                System.out.println("En sekvens er kortere enn 3. Avslutter program ...");
                System.exit(1);
            }
            
            // Finner og lager mulige subsekvenser i linjen
            for (int i = 0; i < sekvens.length() - 2; i++) {
                String subsekvensString = sekvens.substring(i, i + 3);
                Subsekvens subsekvens = new Subsekvens(subsekvensString);

                // Legger til i HashMap hvis nøkkelen ikke allerede finnes 
                if (!subs.containsKey(subsekvensString)) {
                    subs.put(subsekvensString, subsekvens);
                }
            }
        }

        return subs;
    }

    // Fletter to HashMaps med subsekvenser sammen til en HashMap med subsekvenser
    public static HashMap<String,Subsekvens> flettImmunrepetoar(HashMap<String,Subsekvens> hashmap1, HashMap<String,Subsekvens> hashmap2) {
        HashMap<String,Subsekvens> flettetSubs = new HashMap<>();

        // Legger til subsekvensene i første HashMap
        for (String subsekvensString : hashmap1.keySet()) {
            flettetSubs.put(subsekvensString, hashmap1.get(subsekvensString));
        }

        // Legger til subsekvensen i andre HashMap eller øker antallet hvis en subsekvens allerede eksisterer
        for (String subsekvensString : hashmap2.keySet()) {
            
            if (!flettetSubs.containsKey(subsekvensString)) {
                flettetSubs.put(subsekvensString, hashmap2.get(subsekvensString));
            } else {
                flettetSubs.get(subsekvensString).tell();
            }
        }

        return flettetSubs;
    }

    public Iterator<HashMap<String,Subsekvens>> iterator() {
        return register.iterator();
    }
}
