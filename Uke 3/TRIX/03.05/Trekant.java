public class Trekant extends Figur {
    private int grunnlinje;
    private int hoyde;

    public Trekant(int g, int h) {
        grunnlinje = g;
        hoyde = h;
        areal = (grunnlinje * hoyde) / 2;
    }

    public double hentAreal() {
        return areal;
    }
}
