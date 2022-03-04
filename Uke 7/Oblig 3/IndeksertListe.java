public class IndeksertListe<T> extends Lenkeliste<T> {
    
    // Legger til nytt element ved bestemt posisjon
    public void leggTil(int pos, T x) {
        Node nyNode;
        Node gjeldendeNode = start;

        throwUgyldigListeindeksExceptionLeggTil(pos);

        // Hvis listen er tom - spesialtilfelle
        if (antallNoder == 0) {
            nyNode = new Node(x);
            start = nyNode;
            slutt = nyNode;
        // Hvis posisjonen er 0 - spesialtilfelle
        } else if (pos == 0) {
            nyNode = new Node(x);
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
        // Setter inn element ved angitt posisjon
        } else {
            nyNode = new Node(x);
            for (int i = 1; i < pos; i++) {
                gjeldendeNode = gjeldendeNode.neste;
            }
            nyNode.forrige = gjeldendeNode;
            nyNode.neste = gjeldendeNode.neste;
            gjeldendeNode.neste = nyNode;

            // Hvis elementet legges midt i listen må denne linjen kjøres i tillegg for at den skal bli dobbeltlenket
            if (nyNode.neste != null) {
                nyNode.neste.forrige = nyNode;
            }
            
            // Hvis elementet legges til på slutten blir sluttpekeren lik den nye noden
            if (pos == antallNoder - 1) {
                slutt = nyNode;
            }
        }


    }

    // Endrer elementet i listen ved den angitte posisjonen
    public void sett(int pos, T x) {
        Node gjeldendeNode = start;

        throwUgyldigListeindeksException(pos);

        for (int i = 0; i < pos; i++) {
            gjeldendeNode = gjeldendeNode.neste;
        }

        gjeldendeNode.data = x;
    }

    // Returnerer elementet ved den angitte posisjonen
    public T hent(int pos) {
        Node gjeldendeNode = start;

        throwUgyldigListeindeksException(pos);

        for (int i = 0; i < pos; i++) {
            gjeldendeNode = gjeldendeNode.neste;
        }

        return gjeldendeNode.data;
    }

    // Fjerner elementet ved den angitte posisjonen
    public T fjern(int pos) {
        Node gjeldendeNode = start;
        T fjernetData;

        throwUgyldigListeindeksException(pos);

        // Spesialtilfelle dersom elementet som fjernes er det første elementet
        if (pos == 0) {
            fjernetData = start.data;
            start = start.neste;

            if (start != null) {
                start.forrige = null;
            }
        // Fjerner elementer ved angitt posisjon
        } else {
            for (int i = 1; i < pos; i++) {
                gjeldendeNode = gjeldendeNode.neste;
            }
            fjernetData = gjeldendeNode.neste.data;
            gjeldendeNode.neste = gjeldendeNode.neste.neste;

            // Denne linjen må kjøres hvis elementet legges til mellom to andre elementer i listen
            if (gjeldendeNode.neste != null) {
                gjeldendeNode.neste.forrige = gjeldendeNode;
            }

            // Setter sluttpeker hvis elementet legges til på slutten av listen
            if (pos == antallNoder - 1) {
                slutt = gjeldendeNode;
            }
            
            
        }

        antallNoder--;
        return fjernetData;
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
