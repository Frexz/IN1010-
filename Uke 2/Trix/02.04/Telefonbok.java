import java.util.HashMap;
import java.util.Scanner;

public class Telefonbok {
    public static void main(String[] args) {
        
        // Oppretter HashMap objekt
        HashMap<String, String> telefonbok = new HashMap<String, String>();

        // Legger til navn og nummer i telefonboken
        telefonbok.put("Arne", "22334455");
        telefonbok.put("Lisa", "95959595");
        telefonbok.put("Jonas", "97959795");
        telefonbok.put("Peder", "12345678");

        // Oppretter Scanner objekt og deklarerer variabler
        Scanner inp = new Scanner(System.in);

        int input = 0;
        
        // Ordreløkke der bruker kan søke opp en persons telefonnummer
        while (input != 1) {
            System.out.println("0 Sok etter person\n1 Avslutt");
            input = inp.nextInt();

            if (input == 0) {
                System.out.println("Skriv inn navnet paa personen du soker etter: ");
                String navn = inp.next();
                
                if (telefonbok.containsKey(navn)) {
                    String nummer = telefonbok.get(navn);

                    String streng = String.format("Navn: %s\nTelefonnummer: %s\n", navn, nummer);
                    System.out.println(streng); 
                }
                else {
                    System.out.println("Telefonboken inneholder ikke dette navnet.\n");
                }
            }
        }
        inp.close();

        // Avslutter programmet med å skrive ut hele telefonboken
        for (String i : telefonbok.keySet()) {
            String streng = String.format("Navn: %s\nTelefonnummer: %s\n", i, telefonbok.get(i));
            System.out.println(streng);
        }
    }
}
