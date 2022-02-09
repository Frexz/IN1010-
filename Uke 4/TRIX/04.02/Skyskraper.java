public class Skyskraper extends Bygning {

    int antallEtasjer;

    public Skyskraper(double bruttoAreal, int antallEtasjer) {
        super(bruttoAreal);
        this.antallEtasjer = antallEtasjer;
        System.out.println("Dette er en skyskraper.");
    }
}
