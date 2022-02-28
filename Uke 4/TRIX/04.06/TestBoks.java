public class TestBoks {
    public static void main(String[] args) {
        

        // Oppretter to bokser
        Boks b1 = new Boks(2, 2, 2);
        Boks b2 = new Boks(4, 5, 6);

        // Test 1 - B1 beregnAreal()
        if (b1.beregnAreal() == 24) {
            System.err.println("Riktig 1");
        } else {
            System.out.println("Feil 1");
        }

        // Test 2 - B2 beregnAreal()
        if (b2.beregnAreal() == 148) {
            System.out.println("Riktig 2");
        } else {
            System.out.println("Feil 2");
        }

        // Test 3 - B1 beregnVolum()
        if (b1.beregnVolum() == 8) {
            System.out.println("Riktig 3");
        } else {
            System.out.println("Feil 3");
        }

        // Test 4 - B2 beregnVolum()
        if (b2.beregnVolum() == 120) {
            System.out.println("Riktig 4");
        } else {
            System.out.println("Feil 4");
        }
    }
}
