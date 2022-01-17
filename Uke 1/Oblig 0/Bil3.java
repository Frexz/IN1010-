public class Bil3 {
    private String regNum;

    /* Konstruktøren
    @param String regNum, registreringsnummer til bil */
    public Bil3(String regNum) {
        this.regNum = regNum;
    }

    // Skriver ut registreringsnummeret til bilen
    public void skrivUt() {
        System.out.printf("Registreringsnummer: %s", regNum);
    }

    /* Henter registreringsnummer
    @return String regNum, registreringsnummer til bilen */
    public String hentNummer() {
        return regNum;
    }


}
