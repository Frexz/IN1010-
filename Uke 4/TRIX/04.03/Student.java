public abstract class Student extends Person {
    protected String kurs;
    protected String laerested;
    
    public Student(String navn, int alder, String kurs, String laerested) {
        super(navn, alder);
        this.kurs = kurs;
        this.laerested = laerested;
    }

    public void skrivUtInfo() {
        System.out.println("Navn: " + navn);
        System.out.println("Alder: " + alder);
        System.out.println("Kurs: " + kurs);
        System.out.println("Lærested: " + laerested);
    }
    
    public abstract boolean harTilgang();
}
