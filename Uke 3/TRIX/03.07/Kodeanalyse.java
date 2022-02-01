public class Kodeanalyse {
    public static void main(String[] args) {
        
        // Test 1
        X x1 = (X) new Y();
        Y y1 = new Y();
        // Ulovlig Y y2 = new X();
        Y y3 = new Z();
        Z z1 = new Z();
        // Ulovlig Z z2 = (Z) new X();

        // Test 2
        S q = new G();
        Q b = new Q();
        B s = new Q();
        B g = new B();
        S p = new B();

        boolean answer = q instanceof B;
        System.out.println(answer);

        answer = q instanceof G;
        System.out.println(answer);

        answer = q instanceof S;
        System.out.println(answer);

        answer = b instanceof B;
        System.out.println(answer);

        answer = b instanceof S;
        System.out.println(answer);

        answer = s instanceof B;
        System.out.println(answer);

        answer = g instanceof Q;
        System.out.println(answer);

        answer = g instanceof S;
        System.out.println(answer);

        answer = p instanceof Q;
        System.out.println(answer);

        answer = p instanceof S;
        System.out.println(answer);

        answer = p instanceof G;
        System.out.println(answer);

        // Test 3
        Person pers, pers2;
        Student stud, stud2;
        BachelorStudent bachelor, bachelor2;

        pers = new Person();
        stud = new Student();
        bachelor = new BachelorStudent();

        pers2 = stud;

        // Ulovlig: Et studentobjekt har ikke bachelor-egenskaper 
        //bachelor2 = (BachelorStudent) stud;

        // Ulovlig: Et studentobjekt har ikke bachelor-egenskaper
        // stud2 = (BachelorStudent) stud;

        // Ulovlig: En person har ikke studentegenskaper som stud2 peker på
        // stud2 = (Person) stud;

        // Ulovlig: Første del er ok, bachelor kan castes til student fordi en bachelor har studentegenskaper.
        // I andre del peker stud2 på studentegenskapene til et nå studentobjekt. Studentobjekter har ikke bacheloregenskaper.
        //stud2 = (Student) bachelor; bachelor = stud2;
    }
}
