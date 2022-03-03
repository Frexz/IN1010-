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
        } else {
            nyNode = new Node(x);
            for (int i = 1; i < pos; i++) {
                gjeldendeNode = gjeldendeNode.neste;
            }
            nyNode.forrige = gjeldendeNode;
            nyNode.neste = gjeldendeNode.neste;
            gjeldendeNode.neste = nyNode;

            // Hvis noden legges midt i listen må denne linjen kjøres i tillegg for at den skal bli dobbeltlenket
            if (nyNode.neste != null) {
                nyNode.neste.forrige = nyNode;
            }
            
            // Hvis noden legge til på slutten bli sluttpekeren lik den nye noden
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

        } else {
            for (int i = 1; i < pos; i++) {
                gjeldendeNode = gjeldendeNode.neste;
            }
            fjernetData = gjeldendeNode.neste.data;
            gjeldendeNode.neste = gjeldendeNode.neste.neste;

            if (gjeldendeNode.neste != null) {
                gjeldendeNode.neste.forrige = gjeldendeNode;
            }

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
