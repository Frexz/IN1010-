public class BlaaResept extends Resept {
    
    // Konstruktør
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendLege, int pasientId, int reit) {
        super(legemiddel, utskrivendLege, pasientId, reit);
        rabatt = 0.75;
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
}
