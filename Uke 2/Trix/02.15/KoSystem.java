import java.util.ArrayList;

public class KoSystem {
    private ArrayList<KoLapp> koLapper = new ArrayList<KoLapp>();
    
    // Lager et nytt objekt av KoLapp, printer ut informasjon om den og legger
    // den til i listen over koLapper
    public void trekkKoLapp() {
        if (koLapper.size() == 0) {
            KoLapp kolapp = new KoLapp(1);
            koLapper.add(kolapp);
            System.out.println("Du har fått tildelt billettnr 1.");
            System.out.println("Det står 0 foran deg.");
        }
        else {
            int sisteNummerIKoen = koLapper.get(koLapper.size() - 1).hentNummer();
            KoLapp koLapp = new KoLapp(sisteNummerIKoen + 1);

            koLapper.add(koLapp);

            int personerForan = koLapper.size() - 1;
            System.out.printf("Du har fått tildelt billettnr %d.\n", sisteNummerIKoen + 1);
            System.out.printf("Det står %d foran deg.\n", personerForan);

        }
    }

    // Henter ut, printer ut informasjon og fjerner den første kølappen i lista.
    // Gir feilmelding dersom ingen kunder står i kø
    public void betjenKunde() {
        if (koLapper.size() == 0) {
            System.out.println("Det står ingen kunder i kø.");
        }
        else {
            int nummer = koLapper.get(0).hentNummer();
            koLapper.remove(0);
            System.out.printf("Kunde med billettnr. %d er betjent.\n", nummer);
        }
    }

    // Returnerer antall kunder som er i kø
    public int antKunder() {
        int antall = koLapper.size();
        return antall;
    }

    // Printer alle kunder i kø
    public void printKunderIKo() {

    }
}
