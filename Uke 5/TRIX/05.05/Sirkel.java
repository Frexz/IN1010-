public class Sirkel implements Figur {
    
    private double radius;

    public Sirkel(double r) {
        radius = r;
    }

    public double beregnAreal() {
        double areal = Math.PI * Math.pow(radius, 2);
        return areal;
    }

    public double beregnOmkrets() {
        double omkrets = 2 * Math.PI * radius;
        return omkrets;
    }
}
