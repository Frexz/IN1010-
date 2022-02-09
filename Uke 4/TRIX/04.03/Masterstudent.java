public class Masterstudent extends Student {
    
    public Masterstudent(String navn, int alder, String kurs, String laerested) {
        super(navn, alder, kurs, laerested);
    }

    public void skrivUtInfo() {
        System.out.println("\nMASTERSTUDENT");
        super.skrivUtInfo();
    }

    public boolean harTilgang() {
        return true;
    }

}
