public class Utskrift {
    public static void main(String[] args) {
        String txt = "Hallo der!";
        int num1 = 10;
        int num2 = 5;

        utskrift(txt);
        utskrift(num1, num2);
    }

    public static void utskrift(String tekst) {
        System.out.println(tekst);
    }

    public static void utskrift(int a, int b) {
        System.out.println(a + b);
    }
}
