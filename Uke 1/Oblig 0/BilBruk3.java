public class BilBruk3 {
    public static void main(String[] args) {

        // Oppretter bil- og personobjekt
        Bil3 bil = new Bil3("PI 31415");
        Person person = new Person(bil);

        // Skriver ut bilnummer til bilen som personen eier
        person.skrivUtBilnummer();
    }
}