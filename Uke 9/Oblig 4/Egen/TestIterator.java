import java.util.ArrayList;

public class TestIterator {
    public static void main(String[] args) {
        String a = "A";
        String b = "B";
        String c = "C";
        String z = "D";
        
        ArrayList<String> arr = new ArrayList<>();
        Stabel<String> stabel = new Stabel<>();
        Koe<String> koe = new Koe<>();
        IndeksertListe<String> indeksert = new IndeksertListe<>();
        Prioritetskoe<String> prioritet = new Prioritetskoe<>();

        // Test lenkelister
        //prioritet.leggTil(c);
        //prioritet.leggTil(a);
        //prioritet.leggTil(b);
        //prioritet.leggTil(z);

        for (String string : stabel) {
            System.out.println(string);
        }

        System.out.println("Bryr seg ikke om tom liste.");

        stabel.leggTil(a);
        for (String string : stabel) {
            System.out.println(string);
        }

        Pasient pasient = new Pasient("Helge Soerensen", "17028945678");
        System.out.println(pasient);
    }
}
