public class Vanlig extends Legemiddel {
    
    // Konstruktør 
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }

    @Override
    public String hentType() {
        return "vanlig";
    }

    @Override
    public String toString() {
        return "\nVanlig legemiddel\n-----------------" + super.toString();
    }
}
