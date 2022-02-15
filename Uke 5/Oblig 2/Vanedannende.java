public class Vanedannende extends Legemiddel {
    
    // Deklarerer instansvariabler
    protected int vanedannendeStyrke;

    // Konstruktør
    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        vanedannendeStyrke = styrke;
    }

    // Returner styrke
    public int hentVanedannendeStyrke() {
        return vanedannendeStyrke;
    }

    @Override
    public String toString() {
        return ("\nVanedannende legemiddel\n-----------------------" + super.toString() + "\nVanedannende styrke: " + vanedannendeStyrke);
    }
}
