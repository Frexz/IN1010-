public class Parkeringshus {
    
    static Parkeringsplass[] etasje1 = new Parkeringsplass[10];
    static Parkeringsplass[] etasje2 = new Parkeringsplass[10];

    public static void main(String[] args) {
        
        Bil b1 = new Bil("REX", 4);
        Bil b2 = new Bil("ROX", 2);
        Bil b3 = new Bil("RAX", 7);

        Motorsykkel m1 = new Motorsykkel("LEX", 10);
        Motorsykkel m2 = new Motorsykkel("LOX", 12);
        Motorsykkel m3 = new Motorsykkel("LAX", 8);

        etasje1[5] = new Parkeringsplass<Bil>();
        etasje1[5].parker(b1);

        etasje2[6] = new Parkeringsplass<Bil>();
        etasje2[6].parker(b2);

        etasje1[3] = new Parkeringsplass<Bil>();
        etasje1[3].parker(b3);

        etasje1[7] = new Parkeringsplass<Motorsykkel>();
        etasje1[7].parker(m1);

        etasje2[5] = new Parkeringsplass<Motorsykkel>();
        etasje2[5].parker(m2);

        etasje2[1] = new Parkeringsplass<Motorsykkel>();
        etasje2[1].parker(m3);

        for (int i = 0; i < 10; i++) {
            if (etasje1[i] != null) {
                etasje1[i].kjorUt();
                etasje1[i] = null;
            }
            if (etasje2[i] != null) {
                etasje2[i].kjorUt();
                etasje2[i] = null;
            }
        }
    }

}
