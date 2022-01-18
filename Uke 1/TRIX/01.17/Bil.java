public class Bil {
    private String eier;
    private String merke;

    public Bil(String navn, String mrk) {
        eier = navn;
        merke = mrk;
    }

    public void skrivUtInfo() {
        System.out.println("Eier: " + eier + "\nMerke: " + merke);
    }
}
