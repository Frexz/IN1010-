public abstract class Lenkeliste<T> implements Liste<T> {

    // Indre klasse Node som er med å bygge opp strukturen i beholderen
    class Node {
        Node neste = null;
        T data;
        Node(T x) {
            data = x;
            antallNoder++;
        }
    }

    // Lenkelistens instansvariabler
    protected Node start = null;
    protected int antallNoder = 0;

    // Returnerer antall elementer
    public int stoerrelse() {
        return antallNoder;
    }

    // Legger til et nytt element
    public void leggTil(T x) {
        Node nyNode;
        Node peker = start;

        // Lar start referere til ny node hvis lenkelisten er tom
        if (antallNoder == 0) {
            nyNode = new Node(x);
            start = nyNode;
        
        // Finner siste node og lar den neste referere til ny node
        } else {
            for (int i = 1; i < antallNoder; i++) {
                peker = peker.neste;
            }

            nyNode = new Node(x);
            peker.neste = nyNode;
        }
    }

    // Returnerer første elementet i listen uten å fjerne det
    public T hent() {
        return start.data;
    }

    // Fjerner det første elementet i listen og returnerer det
    public T fjern() {
        if (start == null) {
            throw new UgyldigListeindeks(-1);
        }

        T fjernetData = start.data;

        // Håndtering hvis listen er tom etter fjerning av første element
        if (start.neste == null) {
            start = null;
        } else {
            start = start.neste;
        }

        antallNoder--;
        return fjernetData;
    }

    @Override
    public String toString() {
        String resultatStreng = "";
        Node peker = start;

        for (int i = 0; i < antallNoder; i++) {
            resultatStreng = resultatStreng + peker.data + "\n";
            peker = peker.neste;
        }

        return resultatStreng;
    }
}
