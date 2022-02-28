public class Islandshest extends Hest implements KanToelte, KanPasse {
    
    public Islandshest(String n, int a) {
        super(n, a);
    }

    public void toelt() {
        System.out.println(navn + " beveger seg raskt med hevede bein i firtakt.");
    }

    public void pass() {
        System.out.println(navn + " beveger seg svevende med beina i totakt.");
    }


}
