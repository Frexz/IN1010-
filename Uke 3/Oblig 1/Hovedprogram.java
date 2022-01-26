public class Hovedprogram {
    public static void main(String[] args) {
        
        // Oppretter dataklynge
        Dataklynge saga = new Dataklynge();

        // Sett inn 450 noder med 4 prosessorer og 512 GB minne
        for (int i = 0; i < 450; i++) {
            saga.settInnIRack(new Node(4, 512));
        }

        // Sett inn 16 noder med 8 prosessorer og 1024 GB minne
        for (int i = 0; i < 18; i++) {
            saga.settInnIRack(new Node(8, 1024));
        }

        // Skriv ut informasjon om dataklyngen
        System.out.printf("Noder med minst 128 GB: %d\n", saga.noderMedNokMinne(128));
        System.out.printf("Noder med minst 512 GB: %d\n", saga.noderMedNokMinne(512));
        System.out.printf("Noder med minst 1024 GB: %d\n\n", saga.noderMedNokMinne(1024));
        System.out.printf("Antall prosessorer: %d\n", saga.antProsessorer());
        System.out.printf("Antall rack: %d\n", saga.antallRack());
    }
}
