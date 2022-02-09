public abstract class Legemiddel {
    
    // Deklarerer instansvariabler
    protected static int klasseID = 1;
    protected int id;
    protected String navn;
    protected int pris;
    protected double virkestoff;

    // Konstruktør
    public Legemiddel(String navn, int pris, double virkestoff) {
        id = klasseID;
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        klasseID++;
    }

    // Returnerer ID
    public int hentId() {
        return id;
    }

    // Returnerer navn
    public String hentNavn() {
        return navn;
    }

    // Returnerer pris
    public int hentPris() {
        return pris;
    }

    // Returnerer virkestoff
    public double hentVirkestoff() {
        return virkestoff;
    }

    // Endrer prisen til legemiddelet
    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    // Overskriver toString()
    @Override
    public String toString() {
        return ("\nID: " + id + "\nNavn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff);
    }
}
