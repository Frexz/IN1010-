public abstract class Kjoretoy {
    protected String regnummer;
    protected String merke;
    protected String eier;

    public Kjoretoy(String reg, String merke, String eier) {
        regnummer = reg;
        this.merke = merke;
        this.eier = eier;
    }

    public void skrivInfo() {
        System.out.println("Registreringsnummer: " + regnummer);
        System.out.println("Fabrikkmerke: " + merke);
        System.out.println("Eier: " + eier);
    }

    public String hentRegnummer() {
        return regnummer;
    }

    public String hentMerke() {
        return merke;
    }

    public String hentEier() {
        return eier;
    }
    
}
