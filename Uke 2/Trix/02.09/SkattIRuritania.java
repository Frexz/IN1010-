import java.util.Scanner;

public class SkattIRuritania {
    public static void main(String[] args) {
        
        // Oprett Scanner objekt og les inn inntekt
        Scanner inp = new Scanner(System.in);
        System.out.println("Skriv inn intekten din: ");
        double inntekt = inp.nextDouble();
        inp.close();

        // Beregner skatt
        double skatt;

        if (inntekt < 10000) {
            skatt = inntekt*0.10;
        }
        else {
            skatt = 10000*0.10 + (inntekt - 10000)*0.30;        }
        
        // Skriver ut skatt til terminal
        String streng = String.format("Du maa betale %.2f kr i skatt.", skatt);
        System.out.println(streng);    }
}
