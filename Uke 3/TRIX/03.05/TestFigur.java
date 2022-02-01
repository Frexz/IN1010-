public class TestFigur {
    public static void main(String[] args) {
        Trekant t = new Trekant(3, 2);
        Sirkel s = new Sirkel(3);
        Rektangel r = new Rektangel(3, 7);
        Kvadrat k = new Kvadrat(4);
        double sum = 0;

        sum += t.hentAreal();
        sum += s.hentAreal();
        sum += r.hentAreal();
        sum += k.hentAreal();

        System.out.printf("%.4f\n", sum);
    }
}
