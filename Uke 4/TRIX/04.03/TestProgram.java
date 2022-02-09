public class TestProgram {
    public static void main(String[] args) {
        
        Bachelorstudent b1 = new Bachelorstudent("Henrik", 28, "IN1010", "UiO");
        Masterstudent m1 = new Masterstudent("Helena", 25, "IN1010", "UiO");
        Forsker f1 = new Forsker("Heinz", 58, 350, "Matematikkhistorie");
        Professor p1 = new Professor("Elena", 60, 400, "Astronomi", "IN1010");

        b1.skrivUtInfo();
        m1.skrivUtInfo();
        f1.skrivUtInfo();
        p1.skrivUtInfo();

        System.out.println(b1.harTilgang());
        System.out.println(m1.harTilgang());
    }
}
