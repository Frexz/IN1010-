public class Student {
    
    // Deklarerer instansvariabler
    private String navn;
    private int quizScore;
    private int antallQuiz;

    // Konstruktør
    public Student(String navn) {
        this.navn = navn;
        quizScore = 0;
        antallQuiz = 0;
    }

    // Returnerer studentens navn
    public String hentNavn() {
        return navn;
    }

    // Legger till en bestemt score til total quizscore og øker antall quizer med én
    public void leggTilQuizScore(int score) {
        quizScore += score;
        antallQuiz ++;
    }

    // Returnerer total quiz score
    public int hentTotalScore() {
        return quizScore;
    }

    // Regner ut gjennomsnittlig quiz score og returnerer den
    public double hentGjennomsnittligScore() {
        double gjennomsnitt = quizScore / antallQuiz;
        return gjennomsnitt;
    }
}
