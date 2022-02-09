public class MilResept extends HvitResept {
    
    // Konstruktør
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
        rabatt = 1.0;
    }

    // Returnerer pris å betale for legemiddelet
    @Override
    public int prisAaBetale() {
        int aaBetale = (int) (legemiddel.hentPris() * (1 - rabatt));
        return aaBetale;
    }

}
