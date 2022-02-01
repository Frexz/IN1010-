import java.util.Scanner;

public class KoProgram {
    public static void main(String[] args) {
        
        KoSystem koSystem = new KoSystem();
        Scanner input = new Scanner(System.in);
        int valg = 0;

        // Ordreløkke
        while (valg != 4) {

            // Skriv ut en meny med menyvalg
            System.out.println("\n**MENY FOR BILLETTSYSTEM**");
            System.out.println("1 - Trekk ny kølapp.");
            System.out.println("2 - Betjen kunde.");
            System.out.println("3 - Print antall kunder i kø.");
            System.out.println("4 - Avslutt.");
            System.out.print("\n> ");

            // Menyvalg
            valg = input.nextInt();

            if (valg == 1) {
                koSystem.trekkKoLapp();
            }
            else if (valg == 2) {
                koSystem.betjenKunde();
            }
            else if (valg == 3) {
                System.out.printf("Det står %d personer i kø.\n", koSystem.antKunder());
            }
            else if (valg == 4) {
                System.out.println("Programmet avsluttes. Takk for nå!");
            }
            else {
                System.out.println("Ugyldig valg.");
            }
        }

        input.close();
    }
}
