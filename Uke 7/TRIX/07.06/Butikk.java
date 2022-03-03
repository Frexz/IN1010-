import java.util.Iterator;

public class Butikk implements Iterable<Person> {
    Person foerst;

    public void entreButikk(Person p) {
        Person peker = foerst;

        if (foerst == null) {
            foerst = p;
            return;
        }

        while (peker.hentNeste() != null) {
            peker = peker.hentNeste();
        }

        peker.settNeste(p);
    }

    public void kassa() {

        if (foerst == null) {
            System.out.println("Ingen flere kunder. Vi stenger butikken for i dag.");
            return;
        }

        Person betjener = foerst;
        foerst = betjener.hentNeste();

        System.out.println(betjener);
        System.out.println("- Hadet bra!");
    }

    public Iterator<Person> iterator() {
        return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person> {
        Person gjeldendePerson = foerst;


        @Override
        public boolean hasNext() {
            return gjeldendePerson != null;
        }

        @Override
        public Person next() {
            Person tmp = gjeldendePerson;
            gjeldendePerson = gjeldendePerson.hentNeste();
            return tmp;
        }
    
    }
}
