public abstract class Ansatt extends Person {
    protected float timelonn;

    public Ansatt(String navn, int alder, float timelonn) {
        super(navn, alder);
        this.timelonn = timelonn;
    }

    public void skrivUtInfo() {
        System.out.println("Navn: " + navn);
        System.out.println("Alder: " + alder);
        System.out.println("Timelønn: " + timelonn);
    }
}
