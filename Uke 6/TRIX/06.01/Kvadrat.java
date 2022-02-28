public class Kvadrat extends Figur {
    private int sidelengde;

    public Kvadrat(int s) {
        sidelengde = s;
        areal = Math.pow(sidelengde, 2);
    }

    public double hentAreal() {
        return areal;
    }
}
