public class TestResepter {
    public static void main(String[] args) {
        
        // Oppretter nødvendige objekter
        Vanlig vanlig1 = new Vanlig("Aerius", 85, 5);
        Vanlig vanlig2 = new Vanlig("Microgynon", 110, 5);
        Narkotisk narkotisk = new Narkotisk("Paralgin forte", 86, 60, 2);
        Vanedannende vanedannende = new Vanedannende("Valium", 101, 5, 2);

        Lege lege = new Lege("Watson");

        HvitResept hvit = new HvitResept(vanlig1, lege, 1, 3);
        MilResept mil = new MilResept(narkotisk, lege, 2);
        PResept pres = new PResept(vanlig2, lege, 3, 5);
        BlaaResept blaa = new BlaaResept(vanedannende, lege, 4, 1);

        Argumenter argumenter = new Argumenter();

        // Setter argumenter og tester HvitResept
        argumenter.settResept(hvit);
        argumenter.settForventetId(1);
        argumenter.settLegemiddel(vanlig1);
        argumenter.settLege(lege);
        argumenter.settForventetPasientId(1);
        argumenter.settForventetReit(3);
        argumenter.settForventetFarge("hvit");
        argumenter.settForventetPris(85);
        testResept(argumenter);
        System.out.println(hvit);

        // Setter argumenter og tester MilResept
        argumenter.settResept(mil);
        argumenter.settForventetId(2);
        argumenter.settLegemiddel(narkotisk);
        argumenter.settLege(lege);
        argumenter.settForventetPasientId(2);
        argumenter.settForventetReit(3);
        argumenter.settForventetFarge("hvit");
        argumenter.settForventetPris(0);
        testResept(argumenter);
        System.out.println(mil);

        // Setter argumenter og tester PResept
        argumenter.settResept(pres);
        argumenter.settForventetId(3);
        argumenter.settLegemiddel(vanlig2);
        argumenter.settLege(lege);
        argumenter.settForventetPasientId(3);
        argumenter.settForventetReit(5);
        argumenter.settForventetFarge("hvit");
        argumenter.settForventetPris(2);
        testResept(argumenter);
        System.out.println(pres);

        // Setter argumenter og tester BlaaResept
        argumenter.settResept(blaa);
        argumenter.settForventetId(4);
        argumenter.settLegemiddel(vanedannende);
        argumenter.settLege(lege);
        argumenter.settForventetPasientId(4);
        argumenter.settForventetReit(1);
        argumenter.settForventetFarge("blaa");
        argumenter.settForventetPris(25);
        testResept(argumenter);
        System.out.println(blaa);
        
    }

    // Tester en vilkårlig resept
    public static void testResept(Argumenter argumenter) {
        System.out.println("\nTester " + argumenter.hentResept().getClass().getSimpleName());
        System.out.println("-------------------");

        // Test 1
        if (testReseptHentId(argumenter.hentResept(), argumenter.hentForventetId())) {
            System.out.println("Riktig 1");
        } else {
            System.out.println("Feil 1");
        }

        // Test 2
        if (testReseptHentLegemiddel(argumenter.hentResept(), argumenter.hentLegemiddel())) {
            System.out.println("Riktig 2");
        } else {
            System.out.println("Feil 2");
        }

        // Test 3
        if (testReseptHentLege(argumenter.hentResept(), argumenter.hentLege())) {
            System.out.println("Riktig 3");
        } else {
            System.out.println("Feil 3");
        }

        // Test 4
        if (testReseptHentPasientId(argumenter.hentResept(), argumenter.hentForventetPasientId())) {
            System.out.println("Riktig 4");
        } else {
            System.out.println("Feil 4");
        }

        // Test 5
        if (testReseptHentReit(argumenter.hentResept(), argumenter.hentForventetReit())) {
            System.out.println("Riktig 5");
        } else {
            System.out.println("Feil 5");
        }

        // Test 6
        if (testReseptBruk(argumenter.hentResept(), argumenter.hentForventetReit())) {
            System.out.println("Riktig 6");
        } else {
            System.out.println("Riktig 6");
        }

        // Test 7
        if (testReseptFarge(argumenter.hentResept(), argumenter.hentForventetFarge())) {
            System.out.println("Riktig 7");
        } else {
            System.out.println("Feil 7");
        }

        // Test 8
        if (testReseptPrisAaBetale(argumenter.hentResept(), argumenter.hentForventetPris())) {
            System.out.println("Riktig 8");
        } else {
            System.out.println("Feil 8");
        }

        // Test 8.1 - Tester pris på legemiddel i PResept ikke blir mindre enn 0 når prisen er mindre enn rabatten.
        if (argumenter.hentResept() instanceof PResept) {
            argumenter.hentLegemiddel().settNyPris(100);
            argumenter.settForventetPris(0);

            if (testReseptPrisAaBetale(argumenter.hentResept(), argumenter.hentForventetPris())) {
                System.out.println("Riktig 8.1");
            } else {
                System.out.println("Feil 8.1");
            }

        // Test 8.2 - Tester pris på legemiddel i BlaaResept om det blir rundet av til nærmeste hele tall
        } else if (argumenter.hentResept() instanceof BlaaResept) {
            argumenter.hentLegemiddel().settNyPris(102);
            argumenter.settForventetPris(26);

            if (testReseptPrisAaBetale(argumenter.hentResept(), argumenter.hentForventetPris())) {
                System.out.println("Riktig 8.2");
            } else {
                System.out.println("Feil 8.2");
            }
        }

    }

    public static boolean testReseptHentId(Resept resept, int forventetId) {
        return resept.hentId() == forventetId;
    }

    public static boolean testReseptHentLegemiddel(Resept resept, Legemiddel forventetLegemiddel) {
        return resept.hentLegemiddel().equals(forventetLegemiddel);
    }

    public static boolean testReseptHentLege(Resept resept, Lege forventetLege) {
        return resept.hentLege().equals(forventetLege);
    }

    public static boolean testReseptHentPasientId(Resept resept, int forventetPasientId) {
        return resept.hentPasientId() == forventetPasientId;
    }

    public static boolean testReseptHentReit(Resept resept, int forventetReit) {
        return resept.hentReit() == forventetReit;
    }

    public static boolean testReseptBruk(Resept resept, int forventetReit) {

        // Sjekker først om resepten kan brukes, returnerer false hvis ikke
        if (!resept.bruk()) {
            return false;
        }

        // Sjekker at reit er én mindre etter bruk, returnerer false hvis ikke
        if (!(resept.hentReit() == forventetReit - 1)) {
            return false;
        }

        // Bruker resepten til det er 0 reit igjen og sjekker om den nå kan brukes. Returnerer false
        // hvis resepten blir brukt
        resept.bruk();
        resept.bruk();

        return !(resept.bruk());

    }
    
    public static boolean testReseptFarge(Resept resept, String forventetFarge) {
        return resept.farge() == forventetFarge;
    }

    public static boolean testReseptPrisAaBetale(Resept resept, int forventetPris) {
        return resept.prisAaBetale() == forventetPris;
    }
}
