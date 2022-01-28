import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    public static void main(String[] args) {
        String filnavn = "dataklynge.txt";

        // Oppretter dataklynge
        Dataklynge saga = new Dataklynge();

        // Legger noder til dataklyngen fra fil
        Hovedprogram.lesFraFil(filnavn, saga);

        // Skriv ut informasjon om dataklyngen
        System.out.printf("Noder med minst 128 GB: %d\n", saga.noderMedNokMinne(128));
        System.out.printf("Noder med minst 512 GB: %d\n", saga.noderMedNokMinne(512));
        System.out.printf("Noder med minst 1024 GB: %d\n\n", saga.noderMedNokMinne(1024));
        System.out.printf("Antall prosessorer: %d\n", saga.antProsessorer());
        System.out.printf("Antall rack: %d\n", saga.antallRack());


    }

    public static void lesFraFil(String filnavn, Dataklynge klynge) {
    
        // Opretter et Scanner-objekt
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
        } 
        catch (Exception e) {
            System.out.println("Finner ikke filen du prøvde å lese.");
        }

        // Leser innhold fra fil og legger til node i dataklyngen
        while (fil.hasNextLine()) {

            // Leser informasjon fra fil
            String[] info = fil.nextLine().split(" ");
            int antallNoder = Integer.parseInt(info[0]);
            int antallProsessorer = Integer.parseInt(info[1]);
            int minne = Integer.parseInt(info[2]);

            // Legger til noder i dataklynge
            for (int i = 0; i < antallNoder; i++) {
                Node node = new Node(antallProsessorer, minne);
                klynge.settInnIRack(node);
            }

        }

        fil.close();
        System.out.println("Noder fra fil har blitt lagt til i dataklynge.");
    }
}
