public class Pasient {
    private static int klasseID = 1;
    private int pasientID;
    private String navn;
    private String foedselsnummer;
    private Stabel<Resept> resepter;

    public Pasient(String navn, String fnr) {
        pasientID = klasseID;
        this.navn = navn;
        foedselsnummer = fnr;
        resepter = new Stabel<>();

        klasseID++;
    }

    public int hentPasientID() {
        return pasientID;
    }

    public void leggTilResept(Resept resept) {
        resepter.leggTil(resept);
    }

    @Override
    public String toString() {
        return "\nPasient\n-------\n" + "ID: " + pasientID + "\nNavn: " + navn + "\nFoedselsnummer: " + foedselsnummer;
    }
}
