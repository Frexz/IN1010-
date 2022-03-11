
// Denne klassen er en beholder for argumenter til bruk i de ulike enhetstestene
public class Argumenter {
    
    // Deklarerer instansvariabler
    private double forventetVirkestoff;
    private int forventetId;
    private int forventetPasientId;
    private int forventetPris;
    private int forventetReit;
    private int forventetStyrke;
    private Lege lege;
    private Legemiddel legemiddel;
    private Pasient pasient;
    private Resept resept;
    private String forventetFarge;
    private String forventetNavn;
    
    
    // Observatorer og modifikatorer
    public double hentForventetVirkestoff() {
        return forventetVirkestoff;
    }

    public void settForventetVirkestoff(double forventetVirkestoff) {
        this.forventetVirkestoff = forventetVirkestoff;
    }

    public int hentForventetId() {
        return forventetId;
    }

    public void settForventetId(int forventetId) {
        this.forventetId = forventetId;
    }

    public int hentForventetPasientId() {
        return forventetPasientId;
    }

    public void settForventetPasientId(int forventetPasientId) {
        this.forventetPasientId = forventetPasientId;
    }

    public int hentForventetPris() {
        return forventetPris;
    }

    public void settForventetPris(int forventetPris) {
        this.forventetPris = forventetPris;
    }

    public int hentForventetReit() {
        return forventetReit;
    }

    public void settForventetReit(int forventetReit) {
        this.forventetReit = forventetReit;
    }

    public int hentForventetStyrke() {
        return forventetStyrke;
    }

    public void settForventetStyrke(int forventetStyrke) {
        this.forventetStyrke = forventetStyrke;
    }

    public Lege hentLege() {
        return lege;
    }

    public void settLege(Lege lege) {
        this.lege = lege;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }
  
    public void settLegemiddel(Legemiddel legemiddel) {
        this.legemiddel = legemiddel;
    }

    public Pasient hentPasient() {
        return pasient;
    }

    public void settPasient(Pasient pasient) {
        this.pasient = pasient;
    }

    public Resept hentResept() {
        return resept;
    }

    public void settResept(Resept resept) {
        this.resept = resept;
    }
    
    public String hentForventetFarge() {
        return forventetFarge;
    }

    public void settForventetFarge(String forventetFarge) {
        this.forventetFarge = forventetFarge;
    }

    public String hentForventetNavn() {
        return forventetNavn;
    }

    public void settForventetNavn(String forventetNavn) {
        this.forventetNavn = forventetNavn;
    }

}
