public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
    
    @Override
    public void leggTil(T x) {
        Node nyNode;
        Node gjeldendeNode = start;

        if (antallNoder == 0) {
            super.leggTil(x);
            return;
        }

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
        }

        super.leggTil(x);

    }

    @Override
    public T hent() {
        return super.hent();
    }

    @Override
    public T fjern() {
        return super.fjern();
    }
}
