public class Personbil extends Kjoretoy {
    int antallSitteplasser;

    public Personbil(String regnummer, String merke, String eier, int sitteplasser) {
        super(regnummer, merke, eier);
        antallSitteplasser = sitteplasser;
    }

    @Override
    public void skrivInfo() {
        super.skrivInfo();
        System.out.println("Antall sitteplasser: " + antallSitteplasser);
    }

    public int hentAntallSitteplasser() {
        return antallSitteplasser;
    }

    public double regnAarsavgift() {
        return 3000;
    }
}
