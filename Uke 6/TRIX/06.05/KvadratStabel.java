public class KvadratStabel {
    private Node start;

    private class Node {
        private Kvadrat data;
        private Node neste;

        private Node(Kvadrat data) {
            this.data = data;
        }
    }

    public void leggPaa(Kvadrat x) {
        Node nyNode = new Node(x);
        nyNode.neste = start;
        start = nyNode;
    }

    public Kvadrat taAv() {
        Kvadrat tmp = start.data;
        start = start.neste;
        return tmp;
    }

    public boolean erTom() {
        return start == null;
    }
}
