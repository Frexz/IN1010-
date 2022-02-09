import java.util.ArrayList;

public class Student {
    private String navn;
    private ArrayList<Fag> fag = new ArrayList<>();

    public Student(String studentnavn) {
        navn = studentnavn;
    }

    public void leggTilFag(Fag emne) {
        fag.add(emne);
    }

    public int antallFag() {
        return fag.size();
    }

    public String hentNavn() {
        return navn;
    }
}
