public class PasoFino extends Hest implements KanToelte {
    
    public PasoFino(String n, int a) {
        super(n, a);
    }

    public void toelt() {
        System.out.println(navn + " beveger seg raskt med hevede bein i firtakt.");
    }
}
