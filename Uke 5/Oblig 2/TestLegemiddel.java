public class TestLegemiddel {
    public static void main(String[] args) {

        // Oppretter objekter av hver subklasse
        Vanlig vanlig = new Vanlig("Aerius", 85, 5);
        Narkotisk narkotisk = new Narkotisk("Paralgin forte", 86, 60, 2);
        Vanedannende vanedannende = new Vanedannende("Valium", 100, 5, 2);
        Argumenter argumenter = new Argumenter();

        // Setter forventede testverdier og tester Vanlig
        argumenter.settLegemiddel(vanlig);
        argumenter.settForventetId(1);
        argumenter.settForventetNavn("Aerius");
        argumenter.settForventetPris(85);
        argumenter.settForventetVirkestoff(5);
        testLegemiddel(argumenter);
        System.out.println(vanlig);

        //Setter forventede testverdier og tester Narkotisk
        argumenter.settLegemiddel(narkotisk);
        argumenter.settForventetId(2);
        argumenter.settForventetNavn("Paralgin forte");
        argumenter.settForventetPris(86);
        argumenter.settForventetVirkestoff(60);
        argumenter.settForventetStyrke(2);
        testLegemiddel(argumenter);
        System.out.println(narkotisk);

        //Tester forventede testverdier og tester Vanedannende
        argumenter.settLegemiddel(vanedannende);
        argumenter.settForventetId(3);
        argumenter.settForventetNavn("Valium");
        argumenter.settForventetPris(100);
        argumenter.settForventetVirkestoff(5);
        argumenter.settForventetStyrke(2);
        testLegemiddel(argumenter);
        System.out.println(vanedannende);
        
    }

    // Tester et vilkårlig legemiddel
    public static void testLegemiddel(Argumenter argumenter) {
        System.out.println("\nTester " + argumenter.hentLegemiddel().getClass().getSimpleName());
        System.out.println("-------------------");
        
        // Test 1
        if (testLegemiddelId(argumenter.hentLegemiddel(), argumenter.hentForventetId())) {
            System.out.println("Riktig 1");
        } else {
            System.out.println("Feil 1");
        }

        // Test 2
        if (testLegemiddelNavn(argumenter.hentLegemiddel(), argumenter.hentForventetNavn())) {
            System.out.println("Riktig 2");
        } else {
            System.out.println("Feil 2");
        }

        // Test 3
        if (testLegemiddelPris(argumenter.hentLegemiddel(), argumenter.hentForventetPris())) {
            System.out.println("Riktig 3");
        } else {
            System.out.println("Feil 3");
        }

        // Test 4
        if (testLegemiddelVirkestoff(argumenter.hentLegemiddel(), argumenter.hentForventetVirkestoff())) {
            System.out.println("Riktig 4");
        } else {
            System.out.println("Feil 4");
        }

        // Test 5
        if (testSettNyPris(argumenter.hentLegemiddel(), 340)) {
            System.out.println("Riktig 5");
        } else {
            System.out.println("Feil 5");
        }

        // Test 6
        if (argumenter.hentLegemiddel() instanceof Narkotisk) {

            // Tester styrken for Narkotisk
            if (testNarkotiskStyrke((Narkotisk) argumenter.hentLegemiddel(), argumenter.hentForventetStyrke())) {
                System.out.println("Riktig 6.1");
            } else {
                System.out.println("Feil 6.1");
            }

            // Tester styrken for Vanedannende
        } else if (argumenter.hentLegemiddel() instanceof Vanedannende) {
            if (testVanedannendeStyrke((Vanedannende) argumenter.hentLegemiddel(), argumenter.hentForventetStyrke())) {
                System.out.println("Riktig 6.2");
            } else {
                System.out.println("Feil 6.2");
            }
        }
    }

    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetId) {
        return legemiddel.hentId() == forventetId;
    }

    public static boolean testLegemiddelNavn(Legemiddel legemiddel, String forventetNavn) {
        return legemiddel.hentNavn() == forventetNavn;
    }

    public static boolean testLegemiddelPris(Legemiddel legemiddel, int forventetPris) {
        return legemiddel.hentPris() == forventetPris;
    }

    public static boolean testLegemiddelVirkestoff(Legemiddel legemiddel, double forventetVirkestoff) {
        return legemiddel.hentVirkestoff() == forventetVirkestoff;
    }

    public static boolean testNarkotiskStyrke(Narkotisk legemiddel, int forventetStyrke) {
        return legemiddel.hentNarkotiskStyrke() == forventetStyrke;
    }

    public static boolean testVanedannendeStyrke(Vanedannende legemiddel, int forventetStyrke) {
        return legemiddel.hentVanedannendeStyrke() == forventetStyrke;
    }

    public static boolean testSettNyPris(Legemiddel legemiddel, int nyPris) {
        legemiddel.settNyPris(nyPris);
        return legemiddel.hentPris() == nyPris;
    }
}
