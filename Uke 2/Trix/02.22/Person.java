public class Person {
    private String navn;
    
    // Konstruktør
    public Person(String navn) {
        this.navn = navn;
    }

    // Hent navn
    public String hentNavn() {
        return navn;
    }
}
