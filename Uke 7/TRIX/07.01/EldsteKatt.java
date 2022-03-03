public class EldsteKatt {
    public static void main(String[] args) {
        Katt[] katter = new Katt[5];

        Katt k1 = new Katt("Felix", 10);
        katter[0] = k1;
        Katt k2 = new Katt("Mons", 5);
        katter[1] = k2;
        Katt k3 = new Katt("Snøhvit", 7);
        katter[2] = k3;
        Katt k4 = new Katt("Buster", 11);
        katter[3] = k4;
        Katt k5 = new Katt("Bolt", 2);
        katter[4] = k5;;


        Katt eldsteKatt = null;
        for (int i = 0; i < katter.length; i++) {
            if (eldsteKatt == null) {
                eldsteKatt = katter[i];
                continue;
            }

            if (katter[i].hentAlder() > eldsteKatt.hentAlder()) {
                eldsteKatt = katter[i];
            }
        }

        System.out.println(eldsteKatt);
    }
}
