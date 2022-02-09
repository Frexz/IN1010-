public class Narkotisk extends Legemiddel {
    
    // Deklarerer instansvariabler
    protected int narkotiskStyrke;

    // Konstruktør
    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        narkotiskStyrke = styrke;
    }

    // Returnerer styrken
    public int hentNarkotiskStyrke() {
        return narkotiskStyrke;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nNarkotisk styrke: " + narkotiskStyrke);
    }
}
