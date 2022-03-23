import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubsekvensRegister {
    ArrayList<HashMap<String,Subsekvens>> register = new ArrayList<>();

    public void settInn(HashMap<String,Subsekvens> subs) {
        register.add(subs);
    }

    // TODO: Skal kunne ta ut et vilkårlig element, men usikker på hva som menes med det.
    public HashMap<String,Subsekvens> hentHashMap(int index) {
        return register.get(index);
    }

    public int stoerrelse() {
        return register.size();
    }

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
            String sekvens = fil.next();
            
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

    public static HashMap<String,Subsekvens> flettImmunrepetoar(HashMap<String,Subsekvens> hashmap1, HashMap<String,Subsekvens> hashmap2) {
        HashMap<String,Subsekvens> flettetSubs = new HashMap<>();

        for (String subsekvensString : hashmap1.keySet()) {
            flettetSubs.put(subsekvensString, hashmap1.get(subsekvensString));
        }

        for (String subsekvensString : hashmap2.keySet()) {
            
            if (!flettetSubs.containsKey(subsekvensString)) {
                flettetSubs.put(subsekvensString, hashmap2.get(subsekvensString));
            } else {
                flettetSubs.get(subsekvensString).tell();
            }
        }

        return flettetSubs;
    }
}
