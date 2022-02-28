public class TestProgram {
    public static void main(String[] args) {
        
        Rektangel rekt = new Rektangel(4, 7);
        Sirkel sirk = new Sirkel(2);

        // Tester rektangel
        if (rekt.beregnAreal() == 28) {
            System.out.println("Riktig RA");
        } else {
            System.out.println("Feil RA");
        }

        if (rekt.beregnOmkrets() == 22) {
            System.out.println("Riktig RO");
        } else {
            System.out.println("Feil RO");
        }

        // Tester sirkel
        double scale = Math.pow(10, 2);
        double areal = sirk.beregnAreal();
        double omkrets = sirk.beregnOmkrets();

        if (Math.round(areal * scale) / scale == 12.57) {
            System.out.println("Riktig SA");
        } else {
            System.out.println("Feil SA");
        }

        if (Math.round(omkrets * scale) / scale == 12.57) {
            System.out.println("Riktig SO");
        } else {
            System.out.println("Feil SO");
        }

    }
    
}
