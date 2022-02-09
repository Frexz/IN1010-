public class TestLegemiddel {
    public static void main(String[] args) {

        // Oppretter objekter av hver subklasse
        Vanlig vanlig = new Vanlig("Aerius", 85, 5);
        Narkotisk narkotisk = new Narkotisk("Paralgin forte", 86, 60, 2);
        Vanedannende vanedannende = new Vanedannende("Valium", 100, 5, 2);
        
        // Tester hvert av objektene
        testObjekt(vanlig, 1, "Aerius", 85, 5, 0);
        testObjekt(narkotisk, 2, "Paralgin forte", 86, 60, 2);
        testObjekt(vanedannende, 3, "Valium", 100, 5, 2);

        // Tester redefinisjonen av toString()-metoden
        System.out.println(vanlig);
        System.out.println(narkotisk);
        System.out.println(vanedannende);
    }

    // Tester et vilkårlig objekt
    public static void testObjekt(Legemiddel legemiddel, int id, String navn, int pris, double virkestoff, int styrke) {
        
        // Test 1.1
        if (testLegemiddelId(legemiddel, id)) {
            System.out.println("\nRiktig 1.1");
        } else {
            System.out.println("\nFeil 1.1");
        }

        // Test 1.2
        if (testLegemiddelNavn(legemiddel, navn)) {
            System.out.println("Riktig 1.2");
        } else {
            System.out.println("Feil 1.2");
        }

        // Test 1.3
        if (testLegemiddelPris(legemiddel, pris)) {
            System.out.println("Riktig 1.3");
        } else {
            System.out.println("Feil 1.3");
        }

        // Test 1.4
        if (testLegemiddelVirkestoff(legemiddel, virkestoff)) {
            System.out.println("Riktig 1.4");
        } else {
            System.out.println("Feil 1.4");
        }

        // Test 1.5
        if (testSettNyPris(legemiddel, 340)) {
            System.out.println("Riktig 1.5");
        } else {
            System.out.println("Feil 1.5");
        }

        // Test 1.6
        if (legemiddel instanceof Narkotisk) {
            if (testNarkotiskStyrke((Narkotisk) legemiddel, styrke)) {
                System.out.println("Riktig 1.6.1");
            } else {
                System.out.println("Feil 1.6.1");
            }
        } else if (legemiddel instanceof Vanedannende) {
            if (testVanedannendeStyrke((Vanedannende) legemiddel, styrke)) {
                System.out.println("Riktig 1.6.2");
            } else {
                System.out.println("Feil 1.6.2");
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
