public class GeneriskStabel<T> {
    private Node start;

    private class Node {
        private T data;
        private Node neste;

        private Node(T data) {
            this.data = data;
        }
    }

    public void leggPaa(T x) {
        Node nyNode = new Node(x);
        nyNode.neste = start;
        start = nyNode;
    }

    public T taAv() {
        T tmp = start.data;
        start = start.neste;
        return tmp;
    }

    public boolean erTom() {
        return start == null;
    }
}
