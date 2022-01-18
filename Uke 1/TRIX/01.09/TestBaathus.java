public class TestBaathus {
    public static void main(String[] args) {
        
        Baathus baathus = new Baathus(3);
        Baat baat1 = new Baat("Yamaha");
        Baat baat2 = new Baat("Skonnert");
        Baat baat3 = new Baat("Frigatt");
        Baat baat4 = new Baat("Katamaran");

        baathus.settInn(baat1);
        baathus.settInn(baat4);
        baathus.settInn(baat2);
        baathus.settInn(baat3);

        baathus.skrivBaater();
    }
}
