import java.util.Scanner;

public class Differanse {
    public static void main(String[] args) {
        // Deklarer alle variabler
        int x;
        int y;
        int differanse;

        // Oppretter et Scanner-objekt og ber om input
        Scanner inp = new Scanner(System.in);
        System.out.println("Oppgi verdien til x: ");
        x = inp.nextInt();
        System.out.println("Oppgi verdien til y: ");
        y = inp.nextInt();
        inp.close();

        // Regner ut differansen og skriver den ut til terminal
        differanse = x - y;
        System.out.printf("Differansen mellom x og y er %d", differanse);
    }
}