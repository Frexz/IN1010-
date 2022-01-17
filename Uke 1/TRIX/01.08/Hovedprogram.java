public class Hovedprogram {
    public static void main(String[] args) {
        
        Rektangel en = new Rektangel(5, 9);
        Rektangel to = new Rektangel(6, 7);

        System.out.println("Arealet til rektangel en er " + en.areal());
        System.out.println("Arealet til rektangel to er " + to.areal());

        en.oekBredde(10);
        to.oekLengde(10);

        System.out.println("Omkretsen til rektangel en er " + en.omktrets());
        System.out.println("Omkretsen til rektangel to er " + to.omktrets());
    }
}
