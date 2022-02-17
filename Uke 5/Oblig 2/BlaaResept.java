public class BlaaResept extends Resept {
    
    protected final double rabatt = 0.75;

    // Konstruktør
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendLege, int pasientId, int reit) {
        super(legemiddel, utskrivendLege, pasientId, reit);
    }

    // Returnerer reseptens farge
    @Override
    public String farge() {
        return "blaa";
    }

    // Returnerer prisen å betale for legemiddelet
    @Override
    public int prisAaBetale() {
         int aaBetale = (int) Math.round(legemiddel.hentPris() * (1 - rabatt));
         return aaBetale;
    }

    @Override
    public String toString() {
        return "\nBlå resept\n----------" + super.toString() + "\nFarge: " + farge() + "\nPris: " + prisAaBetale() + " kr";
    }
}
