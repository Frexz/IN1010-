public class Forsker extends Ansatt {
    protected String fagomraade;

    public Forsker(String navn, int alder, float timelonn, String fagomraade) {
        super(navn, alder, timelonn);
        this.fagomraade = fagomraade;
    }
    
    public void skrivUtInfo() {
        System.out.println("\nFORSKER");
        super.skrivUtInfo();
        System.out.println("Fagområde: " + fagomraade);
    }
}
