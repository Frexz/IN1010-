import java.util.Scanner;

public class Handletur {
    public static void main(String[] args) {
        int broed = 20;
        int melk = 15;
        int ost = 40;
        int yoghurt = 12;
        int total = 0;

        Scanner inp = new Scanner(System.in);

        System.out.println("Hei! Velkommen til IFI-butikken.");
        System.out.println("Hvor mange broed vil du ha?");
        total += inp.nextInt() * broed;
        System.out.println("Hvor mange melk vil du ha?");
        total += inp.nextInt() * melk;
        System.out.println("Hvor mange ost vil du ha?");
        total += inp.nextInt() * ost;
        System.out.println("Hvor mange yoghurt vil du ?");
        total += inp.nextInt() * yoghurt;

        inp.close();

        System.out.printf("Du skal betale: %d kr.", total);
    }
}
