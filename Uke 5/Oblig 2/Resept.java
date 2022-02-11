public abstract class Resept {
    
    // Deklarerer instansvariabler
    protected static int klasseID = 1;
    protected int id;
    protected Legemiddel legemiddel;
    protected Lege lege;
    protected int pasientId;
    protected int reit;
    protected double rabatt;

    // Konstruktør
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        id = klasseID;
        this.legemiddel = legemiddel;
        lege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        klasseID++;
    }

    // Returnerer id
    public int hentId() {
        return id;
    }

    // Returnerer legemiddel
    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    // Returnerer lege
    public Lege hentLege() {
        return lege;
    }

    // Returnerer pasientID
    public int hentPasientId() {
        return pasientId;
    }

    // Returnerer ReIt
    public int hentReit() {
        return reit;
    }

    // Metoden forsøker å bruke resepten. Returnerer false hvis resepten er oppbrukt
    public boolean bruk() {
        if (reit > 0) {
            reit--;
            return true;
        } else {
            return false;
        }
    }

    // Returnerer reseptens farge
    public abstract String farge();

    // Returnerer prisen å betale for legemiddelet
    public abstract int prisAaBetale();

    // Redefinerer toString()-metiden
    @Override
    public String toString() {
        return ("\nID: " + id + "\nLegemiddel: " + legemiddel.hentNavn() + "\nUtskrivende lege: " + lege + "\nPasient ID: " + pasientId + "\nRe-it: " + reit);
    }
}
