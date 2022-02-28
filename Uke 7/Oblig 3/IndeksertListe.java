public class IndeksertListe<T> extends Lenkeliste<T> {
    
    // Legger til nytt element ved bestemt posisjon
    public void leggTil(int pos, T x) {
        Node nyNode;
        Node peker = start;
        Node nyAndreNode;

        throwUgyldigListeindeksExceptionLeggTil(pos);

        // Spesialtilfelle dersom elementet som legges til er det første elementet
        if (pos == 0) {
            nyNode = new Node(x);
            nyAndreNode = peker;
            nyNode.neste = nyAndreNode;
            start = nyNode;
        } else {
            nyNode = new Node(x);
            for (int i = 1; i < pos; i++) {
                peker = peker.neste;
            }
            nyAndreNode = peker.neste;
            nyNode.neste = nyAndreNode;
            peker.neste = nyNode;
        }


    }

    // Endrer elementet i listen ved den angitte posisjonen
    public void sett(int pos, T x) {
        Node peker = start;

        throwUgyldigListeindeksException(pos);

        for (int i = 0; i < pos; i++) {
            peker = peker.neste;
        }

        peker.data = x;
    }

    // Returnerer elementet ved den angitte posisjonen
    public T hent(int pos) {
        Node peker = start;

        throwUgyldigListeindeksException(pos);

        for (int i = 0; i < pos; i++) {
            peker = peker.neste;
        }

        return peker.data;
    }

    // Fjerner elementet ved den angitte posisjonen
    public T fjern(int pos) {
        Node peker = start;
        Node fjernetNode;

        throwUgyldigListeindeksException(pos);

        // Spesialtilfelle dersom elementet som fjernes er det første elementet
        if (pos == 0) {
            fjernetNode = peker;
            start = peker.neste;
        } else {
            for (int i = 1; i < pos; i++) {
                peker = peker.neste;
            }
            fjernetNode = peker.neste;
            peker.neste = peker.neste.neste;
        }

        antallNoder--;
        return fjernetNode.data;
    }

    // Kaster indeks exception ved leggTil-metode
    private void throwUgyldigListeindeksExceptionLeggTil (int pos) {
        if (pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
    }

    // Kaster indeks exception ved øvrige metoder
    private void throwUgyldigListeindeksException (int pos) {
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
    }
}
