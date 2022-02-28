public class Sirkel extends Figur {
    private int radius;

    public Sirkel(int r) {
        radius = r;
        areal = Math.PI * Math.pow(radius, 2);
    }

    public double hentAreal() {
        return areal;
    }

}
