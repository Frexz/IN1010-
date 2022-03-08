public class Lege {

    // Instansvariabler
    protected String navn;

    // Konstruktør
    public Lege(String navn) {
        this.navn = navn;
    }

    // Returnerer legens navn
    public String hentNavn() {
        return navn;
    }

    // Skriver ut informasjon om legen
    @Override
    public String toString() {
        return "\nLege\n----" + "\nNavn: " + navn;
    }
}
