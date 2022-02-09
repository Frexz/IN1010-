public class PResept extends HvitResept {
    
    // Konstruktør
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
        rabatt = 108;
    }

    // Returnerer pris å betale for legemiddelet
    @Override
    public int prisAaBetale() {
        int aaBetale = (int) (legemiddel.hentPris() - rabatt);

        // Sjekker om prisen er mindre enn 0 etter rabatten
        if (aaBetale < 0) {
            return 0;
        } else {
            return aaBetale;
        }
    }
}
