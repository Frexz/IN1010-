public class Varebil extends Kjoretoy {
    protected int maksimalVekt;

    public Varebil(String regnummer, String merke, String eier, int maksimalVekt) {
        super(regnummer, merke, eier);
        this.maksimalVekt = maksimalVekt;
    }

    @Override
    public void skrivInfo() {
        super.skrivInfo();
        System.out.println("Maksimal vekt: " + maksimalVekt);
    }

    public int hentMaksimalVekt() {
        return maksimalVekt;
    }

    public double regnAarsavgift() {
        return 4 * maksimalVekt;
    }
}
