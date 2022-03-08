public class Stabel<T> extends Lenkeliste<T> {
    
    @Override
    public void leggTil(T x) {
        
        // Legger til element hvis listen er tom
        if (antallNoder == 0) {
            Node nyNode = new Node(x);
            start = nyNode;
            slutt = nyNode;
        
        // Legger til element i begynnelsen av listen
        } else {
        Node nyNode = new Node(x);
        nyNode.neste = start;
        start.forrige = nyNode;
        start = nyNode;
        }
    }
}
