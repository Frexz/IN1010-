import java.util.ArrayList;
import java.util.HashMap;

public class Telefonbok {
    public static void main(String[] args) {
        
        // Opprett Person-objekter
        Person p1 = new Person("Augustus", "00707007", "Fylkesveien 98");
        Person p2 = new Person("Finn", "40404040", "Finnsnesveien 12");
        Person p3 = new Person("Kristin", "77778888", "Marnadal");

        /*
        Person[] personliste = new Person[10];

        personliste[0] = p1;
        personliste[1] = p2;
        personliste[2] = p3;

        for (int i = 0; i < 10; i++) {
            
            if (personliste[i] != null) {
                personliste[i].skrivInfo();
            }
        */
        
        /*
        ArrayList<Person> pliste = new ArrayList<Person>();

        pliste.add(p1);
        pliste.add(p2);
        pliste.add(p3);

        for (Person person : pliste) {
            person.skrivInfo();
        }
        */

        HashMap<String, Person> pliste = new HashMap<String, Person>();

        pliste.put(p1.hentNavn(), p1);
        pliste.put(p2.hentNavn(), p2);
        pliste.put(p3.hentNavn(), p3);

        for (Person p : pliste.values()) {
            p.skrivInfo();
        }

    }
}
