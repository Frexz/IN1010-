public class TestParkeringsplass {
    public static void main(String[] args) {
        Parkeringsplass<Bil> bp = new Parkeringsplass<>();
        Parkeringsplass<Motorsykkel> mp = new Parkeringsplass<>();
        Bil b = new Bil("ELVI5", 2);
        Motorsykkel m = new Motorsykkel("L33T", 12);

        bp.parker(b);
        mp.parker(m);
        // Ikke lov - mp.parker(b);
    }
}
