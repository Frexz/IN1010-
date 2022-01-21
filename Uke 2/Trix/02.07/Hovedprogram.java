public class Hovedprogram {
    public static void main(String[] args) {

        // Oppretter tre studentobjekter
        Student student1 = new Student("Joakim");
        Student student2 = new Student("Kristin");
        Student student3 = new Student("Dag");

        // Legger til quizscore på hver av studentene to ganger
        student1.leggTilQuizScore(20);
        student1.leggTilQuizScore(33);
        student2.leggTilQuizScore(15);
        student2.leggTilQuizScore(50);
        student3.leggTilQuizScore(40);
        student3.leggTilQuizScore(33);

        // Skriver ut navn, total score og gjennomsnittlig score
        System.out.printf("Navn: %s\nTotal score: %d\nGj.snittlig score: %.2f\n\n", student1.hentNavn(), student1.hentTotalScore(), student1.hentGjennomsnittligScore());
        System.out.printf("Navn: %s\nTotal score: %d\nGj.snittlig score: %.2f\n\n", student2.hentNavn(), student2.hentTotalScore(), student2.hentGjennomsnittligScore());
        System.out.printf("Navn: %s\nTotal score: %d\nGj.snittlig score: %.2f\n\n", student3.hentNavn(), student3.hentTotalScore(), student3.hentGjennomsnittligScore());
    }
}
