public class Rektangel extends Figur {
    private int lengde;
    private int bredde;

    public Rektangel(int l, int b) {
        lengde = l;
        bredde = b;
        areal = lengde * bredde;
    }

    public double hentAreal() {
        return areal;
    }
}
