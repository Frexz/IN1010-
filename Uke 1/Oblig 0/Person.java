public class Person {
    private Bil3 bil;

    // parameter bil av type Bil3, referanse til bilobjektet personen eier
    public Person(Bil3 b3) {
        bil = b3;
    }

    // Skriver ut registreringsnummeret til bilen som eieren ei
    public void skrivUtBilnummer() {
        System.out.printf("Eiers bils registreringnummer: %s", bil.hentNummer());
    }
}
