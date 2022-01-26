import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    public static void main(String[] args) {
        String filnavn = "dataklynge2.txt";

        // Oppretter dataklynge
        Dataklynge saga = new Dataklynge();

        // Legger noder til dataklyngen fra fil
        Hovedprogram.lesFraFil(filnavn);

        // Skriv ut informasjon om dataklyngen
        /*System.out.printf("Noder med minst 128 GB: %d\n", saga.noderMedNokMinne(128));
        System.out.printf("Noder med minst 512 GB: %d\n", saga.noderMedNokMinne(512));
        System.out.printf("Noder med minst 1024 GB: %d\n\n", saga.noderMedNokMinne(1024));
        System.out.printf("Antall prosessorer: %d\n", saga.antProsessorer());
        System.out.printf("Antall rack: %d\n", saga.antallRack());*/
    }

    public static void lesFraFil(String filnavn) {
    
        // Opretter et Scanner-objekt
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
        } 
        catch (Exception e) {
            System.out.println("Finner ikke filen du prøvde å lese.");        }
        
        // Leser innhold fra fil
        while (fil.hasNextLine()) {
            String[] info = fil.nextLine().split(" ");
            
        }

    }
}
