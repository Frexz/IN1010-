public class Bil2 {
    private String regNum;

    /* Konstruktøren
    @param String regNum, registreringsnummer til bil */
    public Bil2(String regNum) {
        this.regNum = regNum;
    }

    // Skriver ut registreringsnummeret til bilen
    public void skrivUt() {
        System.out.printf("Registreringsnummer: %s", regNum);
    }


}