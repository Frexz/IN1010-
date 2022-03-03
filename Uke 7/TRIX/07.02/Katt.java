public class Katt implements Comparable<Katt> {
    private int alder;
    private String navn;

    public Katt(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public int hentAlder() {
        return alder;
    }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Katten " + navn + " er " + alder + " år gammel.";
    }

    @Override
    public int compareTo(Katt annenKatt) {
        if (this.alder < annenKatt.hentAlder()) {
            return -1;
        } else if (this.alder > annenKatt.hentAlder()) {
            return 1;
        } else {
            return 0;
        }
    }
}
