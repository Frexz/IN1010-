public class Bil2 {
    private String registreringsnummer;

    /* Konstruktøren
    @param String regNum, registreringsnummer til bil */
    public Bil2(String regNum) {
        registreringsnummer = regNum;
    }

    // Skriver ut registreringsnummeret til bilen
    public void skrivUt() {
        System.out.printf("Registreringsnummer: %s", registreringsnummer);
    }


}