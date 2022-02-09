public class Professor extends Ansatt {
    protected String fagomraade;
    protected String kurs;

    public Professor(String navn, int alder, float timelonn, String fagomraade, String kurs) {
        super(navn, alder, timelonn);
        this.fagomraade = fagomraade;
        this.kurs = kurs;
    }

    public void skrivUtInfo() {
        System.out.println("\nPROFESSOR");
        super.skrivUtInfo();
        System.out.println("Fagområde: " + fagomraade);
        System.out.println("Kurs: " + kurs);
    }
}
