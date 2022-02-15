public class TestOrdbeholder {
    public static void main(String[] args) {
        Ordbeholder ordbeholder = new Ordbeholder(); 

        // Test 1
        if (ordbeholder.pop() == null) {
            System.out.println("Riktig 1");
        } else {
            System.out.println("Feil 1");
        }

        // Test 2
        if (ordbeholder.settInn("Hallo")) {
            System.out.println("Riktig 2");
        } else {
            System.out.println("Feil 2");
        }

        // Test 3
        if (!ordbeholder.settInn("Hallo")) {
            System.out.println("Riktig 3");
        } else {
            System.out.println("Feil 3");
        }

        // Test 4
        ordbeholder.settInn("verden");
        ordbeholder.settInn("Jeg");
        ordbeholder.settInn("Norge");

        if (ordbeholder.antallOrd() == 4) {
            System.out.println("Riktig 4");
        } else {
            System.out.println("Feil 4");
        }

        // Test 5
        if (ordbeholder.pop() == "Norge") {
            System.out.println("Riktig 5");
        } else {
            System.out.println("Feil 5");
        }

        // Test 6
        if (ordbeholder.antallOrd() == 3) {
            System.out.println("Riktig 6");
        } else {
            System.out.println("Feil 6");
        }
    }
}
