public class Stabel<T> extends Lenkeliste<T> {
    
    @Override
    public void leggTil(T x) {
        if (antallNoder == 0) {
            Node nyNode = new Node(x);
            start = nyNode;
            slutt = nyNode;
        } else {
        Node nyNode = new Node(x);
        nyNode.neste = start;
        start.forrige = nyNode;
        start = nyNode;
        }
    }
}
