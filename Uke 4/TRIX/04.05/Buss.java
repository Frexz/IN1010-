public class Buss extends Kjoretoy {
    protected int antallSitteplasser;

    public Buss(String regnummer, String merke, String eier, int sitteplasser) {
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
}
