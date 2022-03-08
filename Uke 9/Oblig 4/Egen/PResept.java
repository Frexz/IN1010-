public class PResept extends HvitResept {

    protected final int rabatt = 108;
    
    // Konstruktør
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
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

    @Override
    public String toString() {
        String nyString = super.toString().substring(24);
        return "\nP-resept\n--------" + nyString;
    }
}
