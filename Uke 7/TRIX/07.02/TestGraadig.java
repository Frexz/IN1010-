public class TestGraadig {
    public static void main(String[] args) {
        GraadigBeholder<Katt> g = new GraadigBeholder<>();

        Katt k1 = new Katt("Felix", 11);
        Katt k2 = new Katt("Buster", 2);
        Katt k3 = new Katt("Snøkvit", 12);

        if (g.settInnNyttElement(k1) == null) {
            System.out.println(k1.hentNavn() + " ble lagt til beholderen.");
        }
        
        if (g.settInnNyttElement(k2) == null) {
            System.out.println(k2.hentNavn() + " var ikke gammel nok.");
        }
        
        if (g.settInnNyttElement(k3).hentNavn() == k1.hentNavn()) {
            System.out.println(k1.hentNavn() + " ble erstattet med " + k3.hentNavn());
        }
        
    }
}
