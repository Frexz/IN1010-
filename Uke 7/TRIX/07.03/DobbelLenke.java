public class DobbelLenke<T> {
    private Node start;
    private Node siste;
    private int antallNoder;

    private class Node {
        Node neste = null;
        Node forrige = null;
        T data;

        Node(T x) {
            data = x;
        }

    }

    public void settInn(T x) {
        if (start == null) {
            Node nyNode = new Node(x);
            start = nyNode;
            siste = nyNode;
            antallNoder++;
        } else {
            Node nyNode = new Node(x);
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;
            antallNoder++;
        }
    }


}
