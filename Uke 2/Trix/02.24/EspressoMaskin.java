public class EspressoMaskin {
    int vannmengde;

    public EspressoMaskin() {
        vannmengde = 1000;
    }

    // Lag espresso dersom det er nok vann
    public void lagEspresso() {
        if (sjekkOmNokVann(40)) {
            vannmengde -= 40;
            System.out.println("Her er en nydelig espresso!");
        }
        else {
            System.out.println("Ikke nok vann! Fyll på mer.");
        }
    }

    // Lag lungo dersom det er nok vann
    public void lagLungo() {
        if (sjekkOmNokVann(110)) {
            vannmengde -= 110;
            System.out.println("Her er en nydelig lungo!");
        }
        else {
            System.out.println("Ikke nok vann! Fyll på mer.");
        }
    }

    // Sjekk om det er nok vann
    public boolean sjekkOmNokVann(int ml) {
        if (ml <= vannmengde) {
            return true;
        }
        else {
            return false;
        }
    }

    // Fyll på et gitt antall milliliter vann, dersom det er plass
    public void fyllVann(int ml) {
        if (ml > 1000 - vannmengde) {
            vannmengde = 1000;
        }
        else {
            vannmengde += ml;
        }
        System.out.println("Maskinen er nå fylt opp.");
    }

    // Les av målestrekene på vanntanken og tilgjengelig vann i ml
    public int hentVannmengde() {
        return vannmengde;
    }
}
