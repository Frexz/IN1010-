public class TestButikk {
    public static void main(String[] args) {
        
        Person p1 = new Person("Niels Henrik Abel", "kladdebok med ruter");
        Person p2 = new Person("Vilhelm Bjerknes", "termometer");
        Person p3 = new Person("Sheldon Cooper", "lego");
        Person p4 = new Person("Neil DeGrasse Tyson", "sort hull");
        Person p5 = new Person("Buzz Aldrin", "Buzz Aldrin-actionfigur");

        Butikk butikk = new Butikk();

        butikk.entreButikk(p1);
        butikk.entreButikk(p2);
        butikk.entreButikk(p3);
        butikk.entreButikk(p4);
        butikk.entreButikk(p5);

        for (Person person : butikk) {
            System.out.println(person);
        }
        /*
        for (int i = 0; i < 6; i++) {
            butikk.kassa();
        }*/
    }
}
