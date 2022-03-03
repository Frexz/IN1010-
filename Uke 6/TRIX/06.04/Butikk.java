public class Butikk {
    Person foerst;

    public void entreButikk(Person p) {
        Person peker = foerst;

        if (foerst == null) {
            foerst = p;
            return;
        }

        while (peker.hentNeste() != null) {
            peker = peker.hentNeste();
        }

        peker.settNeste(p);
    }

    public void kassa() {

        if (foerst == null) {
            System.out.println("Ingen flere kunder. Vi stenger butikken for i dag.");
            return;
        }

        Person betjener = foerst;
        foerst = betjener.hentNeste();

        System.out.println(betjener);
        System.out.println("- Hadet bra!");
    }
}
