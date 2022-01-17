public class Person {
    private Bil3 bil;

    // @param Bil3 bil, referanse til bilobjektet personen eier
    public Person(Bil3 bil) {
        this.bil = bil;
    }

    // Skriver ut registreringsnummeret til bilen som eieren ei
    public void skrivUtBilnummer() {
        System.out.println("Eiers bils registreringnummer: " + bil.hentNummer());
    }
}