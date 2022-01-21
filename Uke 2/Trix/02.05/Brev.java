import java.util.ArrayList;

public class Brev {
    private String avsender;
    private String mottaker;
    private ArrayList<String> linjer;

    public Brev(String avs, String mot) {
        avsender = avs;
        mottaker = mot;
        linjer = new ArrayList<String>();
    }

    public void skrivLinje(String linje) {
        linjer.add(linje);
    }

    public void lesBrev() {
        System.out.println("Hei, " + mottaker + "\n");
        for (String linje : linjer) {
            System.out.println(linje);
        }
        System.out.println("\nHilsen fra, " + avsender);
    }
}
