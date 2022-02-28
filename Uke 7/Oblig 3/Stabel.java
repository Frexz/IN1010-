public class Stabel<T> extends Lenkeliste<T> {
    
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node nyAndreNode = start;
        nyNode.neste = nyAndreNode;
        start = nyNode;
    }
}
