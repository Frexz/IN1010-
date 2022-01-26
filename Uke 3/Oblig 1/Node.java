public class Node {
    
    // Deklarerer instansvariabler
    private int antPros;
    private int minne;

    // Konstruktør
    public Node(int antPros, int minne) {
        this.antPros = antPros;
        this.minne = minne;
    }

    // Returnerer antall prosessorer
    public int hentPros() {
        return antPros;
    }

    // Returnerer minne
    public int hentMinne() {
        return minne;
    }
}
