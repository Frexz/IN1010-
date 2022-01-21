import java.util.Scanner;

public class Produkt {
        public static void main(String[] args) {
            
            // Deklarer variabler
            int x;
            int y;
            int produkt;
            int differanse;

            // Opretter et Scanner objekt og leser inn informasjon
            Scanner inp = new Scanner(System.in);
            System.out.println("Oppgi verdien til x: ");
            x = inp.nextInt();
            System.out.println("Oppgi verdien til y: ");
            y = inp.nextInt();
            inp.close();

            // Regner ut produktet
            produkt = x*y;
            System.out.printf("Produktet av x og y er %d%n", produkt);

            // Sjekker om differanse er positiv eller negativ
            differanse = x - y;

            if (differanse >= 0) {
                System.out.println("Differansen mellom x og y er positiv.");
            } 
            else {
                System.out.println("Differansen mellom x og y er negativ.");
            }

        }
}
