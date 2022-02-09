public class Bachelorstudent extends Student {
    
    public Bachelorstudent(String navn, int alder, String kurs, String laerested) {
        super(navn, alder, kurs, laerested);
    }
    
    public void skrivUtInfo() {
        System.out.println("\nBACHELORSTUDENT");
        super.skrivUtInfo();
    }

    public boolean harTilgang() {
        return false;
    }
}
