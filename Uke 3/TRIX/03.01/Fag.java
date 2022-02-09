import java.util.ArrayList;

public class Fag {
    private String emnekode;
    private ArrayList<Student> studenter = new ArrayList<>();

    public Fag(String emnekode) {
        this.emnekode = emnekode;
    }

    public void leggTilStudent(Student stud) {
        studenter.add(stud);
    }

    public int antallStudenter() {
        return studenter.size();
    }

    public void skrivUtStudenter() {
        System.out.printf("Studenter i %s:\n", emnekode);
        for (Student student : studenter) {
            System.out.println(student.hentNavn());
        }
    }

    public String hentEmnekode() {
        return emnekode;
    }
}
