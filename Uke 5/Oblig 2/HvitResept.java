public class HvitResept extends Resept {
    
    // Konstruktør
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Returnerer fargen på resepten
    @Override
    public String farge() {
        return "hvit";
    }

    // Reternerer prisen å betale for legemiddelet
    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }

    // Redefinerer toString()-metiden
    @Override
    public String toString() {
        return "\nHvit resept\n-----------" + super.toString() + "\nFarge: " + farge() + "\nPris: " + prisAaBetale() + " kr";
    }
}
