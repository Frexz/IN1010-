public class TestProgram {
    public static void main(String[] args) {
        
        // Oppretter hesteobjekter
        EngelskFullblodshest full = new EngelskFullblodshest("Pål", 16);
        PasoFino pas = new PasoFino("Per", 15);
        Islandshest isl = new Islandshest("Espen", 14);

        // Tester  Engelskfullblodshest
        full.skritt();
        full.trav();
        full.galopp();

        // Tester PasoFino
        pas.toelt();

        // Tester Islandshest
        isl.toelt();
        isl.pass();
    }
    
}
