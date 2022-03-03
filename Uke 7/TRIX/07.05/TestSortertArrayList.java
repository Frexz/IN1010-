public class TestSortertArrayList {
    public static void main(String[] args) {
        SortertArrayList<Katt> sal = new SortertArrayList<>();

        Katt k1 = new Katt("Feliz", 12);
        Katt k2 = new Katt("Buster", 5);
        Katt k3 = new Katt("Snøkvit", 7);
        Katt k4 = new Katt("Figaro", 1);

        sal.settInn(k1);
        sal.settInn(k2);
        sal.settInn(k3);
        sal.settInn(k4);

        for (int i = 0; i < 4; i++) {
            System.out.println(sal.hentUtForste());
        }
    }
}
