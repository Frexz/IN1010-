public class Person {
    private Person neste;
    private String navn;
    private String vare;

    public Person(String navn, String vare) {
        this.navn = navn;
        this.vare = vare;
    }

    public Person hentNeste() {
        return neste;
    }

    public void settNeste(Person nestePerson) {
        neste = nestePerson;
    }

    @Override
    public String toString() {
        return navn + " kjøper " + vare + ".";
    }
}
