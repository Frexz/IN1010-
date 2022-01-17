public class Rektangel {
    double lengde;
    double bredde;
    
    public Rektangel(double l, double b) {
        lengde = l;
        bredde = b;
    }

    public void oekLengde(int okning) {
        lengde += okning;
    }

    public void oekBredde(int okning) {
        bredde += okning;
    }

    public void reduserBredde(int reduksjon) {

        if (bredde - reduksjon < 0) {
            System.out.println("Bredden kan ikke reduseres så mye.");
        } 
        else {
            bredde -= reduksjon;
        }
    }

    public void reduserLengde(int reduksjon) {
        if (lengde - reduksjon < 0) {
            System.out.println("Lengden kan ikke reduseres så mye.");
        } 
        else {
            lengde -= reduksjon;
        }
    }

    public double areal() {
        return lengde*bredde;
    }

    public double omktrets() {
        return 2*lengde + 2*bredde;
    }
}
