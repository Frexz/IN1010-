import java.util.Scanner;

public class MindreStorre {
        public static void main(String[] args) {
            // Deklarerer variabler
            int tall;

            // Oppretter Scanner objekt og leser inn informasjon
            Scanner input = new Scanner(System.in);
            System.out.println("Tast inn et tall: ");
            tall = input.nextInt();

            // Sjekker om tallet er mindre enn eller større enn 10 og 20
            if (tall >= 10 && tall <= 20) {
                System.out.println("Tallet er mellom 10 og 20");
            }
            else if (tall > 20) {
                System.out.println("Tallet er storre enn 20.");
            }
            else {
                System.out.println("Tallet er mindre enn 10");
            }
        }
}
