public class MilResept extends HvitResept {

    protected static final double rabatt = 1.0;
    
    // Konstruktør
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    // Returnerer pris å betale for legemiddelet
    @Override
    public int prisAaBetale() {
        int aaBetale = (int) (legemiddel.hentPris() * (1 - rabatt));
        return aaBetale;
    }

}
