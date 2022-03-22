import java.util.Iterator;

public abstract class Lenkeliste<T> implements Liste<T> {

    // Indre klasse Node som er med å bygge opp strukturen i beholderen
    class Node {
        Node neste = null;
        Node forrige = null;
        T data;
        Node(T x) {
            data = x;
            antallNoder++;
        }
    }

    // Indre klasse LenkelisteIterator som gjør det mulig å enkelt iterere gjennom lenkelistene
    class LenkelisteIterator implements Iterator<T>{
        private Node gjeldendeNode;
        

        public LenkelisteIterator() {
            // Returnerer hvis listen er tom, kaster NullPointerException hvis ikke denne biten er her.
            // På denne måten oppfører den seg tilsynelatene likt som iteratoren for ArrayList
            if (start == null) {
                return;
            }

            gjeldendeNode = start;
        }

        @Override
        public boolean hasNext() {
            return gjeldendeNode != null;
        }

        @Override
        public T next() {
            T tmp = gjeldendeNode.data;
            gjeldendeNode = gjeldendeNode.neste;
            return tmp;
        }
    }

    // Lenkelistens instansvariabler
    protected Node start = null;
    protected Node slutt = null;
    protected int antallNoder = 0;

    // Returnerer antall elementer
    public int stoerrelse() {
        return antallNoder;
    }

    // Legger til et nytt element
    public void leggTil(T x) {
        Node nyNode;

        // Legger til ny node i listen hvis den er tom
        if (antallNoder == 0) {
            nyNode = new Node(x);
            start = nyNode;
            slutt = nyNode;
        // Legger til ny node etter siste 
        } else {
            nyNode = new Node(x);
            slutt.neste = nyNode;
            nyNode.forrige = slutt;
            slutt = nyNode;
        }
    }

    // Returnerer første elementet i listen uten å fjerne det
    public T hent() {
        if (start == null) {
            throw new UgyldigListeindeks(-1);
        }
        
        return start.data;
    }

    // Fjerner det første elementet i listen og returnerer det
    public T fjern() {
        if (start == null) {
            throw new UgyldigListeindeks(-1);
        }

        T fjernetData = start.data;
        start = start.neste;

        // Setter forrige-peker lik null hvis det er flere elementer igjen i listen etter fjerning
        if (start != null) {
            start.forrige = null;
        }
        
        antallNoder--;
        return fjernetData;
    }

    // Returnerer et nytt iterator-objekt
    public Iterator<T> iterator() {
        return new LenkelisteIterator();
    }

    // Skriver ut innholdet i lenkelisten
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
