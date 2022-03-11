public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
    
    @Override
    public void leggTil(T x) {
        Node nyNode;
        Node gjeldendeNode = start;

        // Legger til element hvis listen er tom
        if (antallNoder == 0) {
            super.leggTil(x);
            return;
        }

        // Legger til elementer slik at elementer med lav verdi legges til før elementer med høy verdi
        for (int i = 0; i < antallNoder; i++) {
            if (x.compareTo(gjeldendeNode.data) < 0) {
                nyNode = new Node(x);
                nyNode.neste = gjeldendeNode;
                nyNode.forrige = gjeldendeNode.forrige;
                gjeldendeNode.forrige = nyNode;

                if (gjeldendeNode != start) {
                    nyNode.forrige.neste = nyNode;
                } else {
                    start = nyNode;
                }
                return;
                
            }

            gjeldendeNode = gjeldendeNode.neste;
        }

        // Legge til element på slutten av listen
        super.leggTil(x);

    }

    // Henter første element
    @Override
    public T hent() {
        return super.hent();
    }

    // Fjerner første element
    @Override
    public T fjern() {
        return super.fjern();
    }
}
