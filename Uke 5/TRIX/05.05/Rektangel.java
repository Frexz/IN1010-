public class Rektangel implements Figur {
    
    private double bredde;
    private double hoyde;

    public Rektangel(double b, double h) {
        bredde = b;
        hoyde = h;
    }

    public double beregnAreal() {
        double areal = bredde * hoyde;
        return areal;
    }

    public double beregnOmkrets() {
        double omkrets = 2 * bredde + 2 * hoyde;
        return omkrets;
    }
}
