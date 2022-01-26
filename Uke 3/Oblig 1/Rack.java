public class Rack {
    
    // Deklarerer instansvariabler
    private int nodesPerRack = 12;
    private Node[] rack = new Node[nodesPerRack];

    // Sjekker om det er ledig plass i racket
    public boolean erFullt() {
        for (Node node : rack) {

            if (node == null) {
                return false;
            }
        }

        return true;
    }

    // Legger til ny node i racket
    public void settInnNode(Node node) {
            for (int i = 0; i < nodesPerRack; i++) {

                if (rack[i] == null) {
                    rack[i] = node;
                    break;
                }
            }
        }
    
    // Returnerer antall prosessorer i racket
    public int antProsessorer() {
        int antPros = 0;

        for (Node node : rack) {
            antPros += node.hentPros();
        }

        return antPros;
    }

    // Returnerer antall noder med nok minne
    public int noderMedNokMinne(int paakrevdMinne) {
        int antall = 0;

        for (Node node : rack) {
            if (node.hentMinne() >= paakrevdMinne) {
                antall++;
            }
        }

        return antall;
    }
}
