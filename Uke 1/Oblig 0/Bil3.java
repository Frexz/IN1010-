public class Bil3 {
    private String registreringsnummer;

    /* Konstruktøren
    parameter regNum av type String, registreringsnummer til bil */
    public Bil3(String regNum) {
        registreringsnummer = regNum;
    }

    // Skriver ut registreringsnummeret til bilen
    public void skrivUt() {
        System.out.printf("Registreringsnummer: %s", registreringsnummer);
    }

    /* Henter registreringsnummer
    returverdi regNum av type String, registreringsnummer til bilen */
    public String hentNummer() {
        return registreringsnummer;
    }


}
