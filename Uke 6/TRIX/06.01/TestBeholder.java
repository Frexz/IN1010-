public class TestBeholder {
    public static void main(String[] args) {
        
        Beholder<Sirkel>b = new Beholder<>();
        Sirkel s = new Sirkel(2);
        Kvadrat k = new Kvadrat(2);

        b.settInn(s);
        b.taUt();
        // Ikke lov - b.settInn(k);
    }
}
